package com.btd.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.compiere.model.MConversionRate;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;

import com.btd.base.CustomProcess;
import com.btd.model.X_BTD_ConfigRate;
import com.btd.util.TimestampUtil;

public class getrates extends CustomProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		List<X_BTD_ConfigRate> configs = new Query(getCtx(), X_BTD_ConfigRate.Table_Name, "AD_Client_ID = ?",
				get_TrxName()).setParameters(getAD_Client_ID()).list();

		for (X_BTD_ConfigRate config : configs) {

			if (config.getType().equals(X_BTD_ConfigRate.TYPE_Promedio)) {
				int countcontrol = 2;
				int count = 0;
				BigDecimal Rate1 = Env.ZERO;
				BigDecimal Rate2 = Env.ZERO;
				while (count < countcontrol) {
					StringBuilder Endpoind = new StringBuilder(config.getURL());
					Endpoind.append("?page=alcambio");
					Endpoind.append("&format_date=iso");
					Endpoind.append("&rounded_price=" + config.isRoundFactor());

					if (count == 1)
						Endpoind.append("&monitor=bcv");
					else
						Endpoind.append("&monitor=enparalelovzla");

					HttpRequest request = HttpRequest.newBuilder().uri(new URI(Endpoind.toString()))
							.header("Content-Type", "application/json").GET().build();
					HttpResponse<String> response = HttpClient.newHttpClient().send(request,
							HttpResponse.BodyHandlers.ofString());
					JSONParser jsonParser = new JSONParser();
					Object objParser = jsonParser.parse(response.body());
					JSONObject mainResult = (JSONObject) objParser;
					if (count == 1)
						Rate1 = new BigDecimal(mainResult.get("price").toString());
					else
						Rate2 = new BigDecimal(mainResult.get("price").toString());

					count++;
				}

				BigDecimal avg_rate = Rate1.add(Rate2).divide(new BigDecimal(2.0),
						config.getC_Currency().getStdPrecision(), RoundingMode.HALF_UP);

				BigDecimal ExistRate = MConversionRate.getRate(config.getC_Currency_ID(), config.getC_Currency_ID_To(),
						TimestampUtil.now(), config.getC_ConversionType_ID(), getAD_Client_ID(), 0);

				if (ExistRate == null) {
					MConversionRate ConversionRate = new MConversionRate(config, config.getC_ConversionType_ID(),
							config.getC_Currency_ID(), config.getC_Currency_ID_To(), avg_rate, TimestampUtil.now());
					ConversionRate.setValidTo(TimestampUtil.now());
					ConversionRate.saveEx();
					addBufferLog(ConversionRate.get_ID(), TimestampUtil.now(), avg_rate, "Tasa Creada ",
							MConversionRate.Table_ID, ConversionRate.get_ID());
				}

			} else {
				StringBuilder Endpoind = new StringBuilder(config.getURL());
				Endpoind.append("?page=" + config.getType());
				Endpoind.append("&format_date=iso");
				Endpoind.append("&rounded_price=" + config.isRoundFactor());

				if (config.getType().equals(X_BTD_ConfigRate.TYPE_BCV))
					Endpoind.append("&monitor=usd");
				else
					Endpoind.append("&monitor=enparalelovzla");

				HttpRequest request = HttpRequest.newBuilder().uri(new URI(Endpoind.toString()))
						.header("Content-Type", "application/json").GET().build();

				HttpResponse<String> response = HttpClient.newHttpClient().send(request,
						HttpResponse.BodyHandlers.ofString());
				JSONParser jsonParser = new JSONParser();
				Object objParser = jsonParser.parse(response.body());
				JSONObject mainResult = (JSONObject) objParser;
				BigDecimal rate = Env.ZERO;
				rate = new BigDecimal(mainResult.get("price").toString());
				BigDecimal ExistRate = MConversionRate.getRate(config.getC_Currency_ID(), config.getC_Currency_ID_To(),
						TimestampUtil.now(), config.getC_ConversionType_ID(), getAD_Client_ID(), 0);

				if (ExistRate == null) {
					MConversionRate ConversionRate = new MConversionRate(config, config.getC_ConversionType_ID(),
							config.getC_Currency_ID(), config.getC_Currency_ID_To(), rate, TimestampUtil.now());
					ConversionRate.setValidTo(TimestampUtil.now());
					ConversionRate.saveEx();
					addBufferLog(ConversionRate.get_ID(), TimestampUtil.now(), rate, "Tasa Creada ",
							MConversionRate.Table_ID, ConversionRate.get_ID());
				} else {

					if (!config.getType().equals(X_BTD_ConfigRate.TYPE_BCV)) {
						final String whereClause = "C_Currency_ID=? and C_Currency_ID_To=? and ValidFrom>=? and ValidTo<=? and C_ConversionType_ID=?";
						MConversionRate rates = new Query(getCtx(), MConversionRate.Table_Name, whereClause,
								get_TrxName())
								.setParameters(config.getC_Currency_ID(), config.getC_Currency_ID_To(),
										TimestampUtil.today(), TimestampUtil.now(), config.getC_ConversionType_ID())
								.first();

						if (rates != null) {
							rates.setMultiplyRate(rate);
							rates.saveEx();
							addBufferLog(rates.get_ID(), TimestampUtil.now(), rate, "Tasa actualizada ",
									MConversionRate.Table_ID, rates.get_ID());
						}
					}

				}

			}

		}
		return "Procesado";
	}

}
