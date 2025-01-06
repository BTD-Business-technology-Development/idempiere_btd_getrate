/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.btd.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BTD_ConfigRate
 *  @author iDempiere (generated) 
 *  @version Release 9 - $Id$ */
@org.adempiere.base.Model(table="BTD_ConfigRate")
public class X_BTD_ConfigRate extends PO implements I_BTD_ConfigRate, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250106L;

    /** Standard Constructor */
    public X_BTD_ConfigRate (Properties ctx, int BTD_ConfigRate_ID, String trxName)
    {
      super (ctx, BTD_ConfigRate_ID, trxName);
      /** if (BTD_ConfigRate_ID == 0)
        {
			setBTD_ConfigRate_ID (0);
			setC_Currency_ID (0);
// @C_Currency_ID@
        } */
    }

    /** Standard Constructor */
    public X_BTD_ConfigRate (Properties ctx, int BTD_ConfigRate_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BTD_ConfigRate_ID, trxName, virtualColumns);
      /** if (BTD_ConfigRate_ID == 0)
        {
			setBTD_ConfigRate_ID (0);
			setC_Currency_ID (0);
// @C_Currency_ID@
        } */
    }

    /** Load Constructor */
    public X_BTD_ConfigRate (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_BTD_ConfigRate[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Config get Rate.
		@param BTD_ConfigRate_ID Config get Rate
	*/
	public void setBTD_ConfigRate_ID (int BTD_ConfigRate_ID)
	{
		if (BTD_ConfigRate_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BTD_ConfigRate_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BTD_ConfigRate_ID, Integer.valueOf(BTD_ConfigRate_ID));
	}

	/** Get Config get Rate.
		@return Config get Rate	  */
	public int getBTD_ConfigRate_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BTD_ConfigRate_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BTD_ConfigRate_UU.
		@param BTD_ConfigRate_UU BTD_ConfigRate_UU
	*/
	public void setBTD_ConfigRate_UU (String BTD_ConfigRate_UU)
	{
		set_Value (COLUMNNAME_BTD_ConfigRate_UU, BTD_ConfigRate_UU);
	}

	/** Get BTD_ConfigRate_UU.
		@return BTD_ConfigRate_UU	  */
	public String getBTD_ConfigRate_UU()
	{
		return (String)get_Value(COLUMNNAME_BTD_ConfigRate_UU);
	}

	public org.compiere.model.I_C_ConversionType getC_ConversionType() throws RuntimeException
	{
		return (org.compiere.model.I_C_ConversionType)MTable.get(getCtx(), org.compiere.model.I_C_ConversionType.Table_ID)
			.getPO(getC_ConversionType_ID(), get_TrxName());
	}

	/** Set Currency Type.
		@param C_ConversionType_ID Currency Conversion Rate Type
	*/
	public void setC_ConversionType_ID (int C_ConversionType_ID)
	{
		if (C_ConversionType_ID < 1)
			set_Value (COLUMNNAME_C_ConversionType_ID, null);
		else
			set_Value (COLUMNNAME_C_ConversionType_ID, Integer.valueOf(C_ConversionType_ID));
	}

	/** Get Currency Type.
		@return Currency Conversion Rate Type
	  */
	public int getC_ConversionType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ConversionType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException
	{
		return (org.compiere.model.I_C_Currency)MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_ID)
			.getPO(getC_Currency_ID(), get_TrxName());
	}

	/** Set Currency.
		@param C_Currency_ID The Currency for this record
	*/
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1)
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Currency.
		@return The Currency for this record
	  */
	public int getC_Currency_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Currency getC_Currency_To() throws RuntimeException
	{
		return (org.compiere.model.I_C_Currency)MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_ID)
			.getPO(getC_Currency_ID_To(), get_TrxName());
	}

	/** Set Currency To.
		@param C_Currency_ID_To Target currency
	*/
	public void setC_Currency_ID_To (int C_Currency_ID_To)
	{
		set_ValueNoCheck (COLUMNNAME_C_Currency_ID_To, Integer.valueOf(C_Currency_ID_To));
	}

	/** Get Currency To.
		@return Target currency
	  */
	public int getC_Currency_ID_To()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID_To);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Round Factor.
		@param RoundFactor Round Factor
	*/
	public void setRoundFactor (boolean RoundFactor)
	{
		set_Value (COLUMNNAME_RoundFactor, Boolean.valueOf(RoundFactor));
	}

	/** Get Round Factor.
		@return Round Factor	  */
	public boolean isRoundFactor()
	{
		Object oo = get_Value(COLUMNNAME_RoundFactor);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** alcambio = alcambio */
	public static final String TYPE_Alcambio = "alcambio";
	/** promedio = avg */
	public static final String TYPE_Promedio = "avg";
	/** BCV = bcv */
	public static final String TYPE_BCV = "bcv";
	/** enparalelovzla = enparalelovzla */
	public static final String TYPE_Enparalelovzla = "enparalelovzla";
	/** Set Type.
		@param Type Type of Validation (SQL, Java Script, Java Language)
	*/
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType()
	{
		return (String)get_Value(COLUMNNAME_Type);
	}

	/** Set URL.
		@param URL Full URL address - e.g. http://www.idempiere.org
	*/
	public void setURL (String URL)
	{
		set_ValueNoCheck (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL()
	{
		return (String)get_Value(COLUMNNAME_URL);
	}
}