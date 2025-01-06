@echo off

set DEBUG_MODE=

if "%1" == "debug" (
  set DEBUG_MODE=debug
)

cd com.btd.getrate.targetplatform
call .\plugin-builder.bat %DEBUG_MODE% ..\com.btd.getrate ..\com.btd.getrate.test
cd ..
