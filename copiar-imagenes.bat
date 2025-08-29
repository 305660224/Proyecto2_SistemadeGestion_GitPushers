@echo off
title COPIADOR DE IMÁGENES - Proyecto GitPushers
echo.
echo 🚀 INICIANDO COPIA DE IMÁGENES...
echo 📍 Proyecto: %CD%
echo.

# Verificar si existe la carpeta source
if not exist "src\GUI\Imagenes" (
    echo ❌ ERROR: No existe la carpeta src\GUI\Imagenes
    echo 📌 Verifica la estructura de carpetas
    pause
    exit 1
)

# Crear carpeta destino si no existe
if not exist "build\classes\GUI\Imagenes" (
    mkdir "build\classes\GUI\Imagenes"
)

# Copiar imágenes
echo 📁 Copiando imágenes...
xcopy /E /I /Y "src\GUI\Imagenes" "build\classes\GUI\Imagenes"

# Verificar resultado
if errorlevel 1 (
    echo ❌ ERROR al copiar imágenes
) else (
    echo ✅ IMÁGENES COPIADAS CORRECTAMENTE
    echo 📍 Ubicación: build\classes\GUI\Imagenes\
)

echo.
echo 🎯 EJECUCIÓN COMPLETADA
echo ⏰ %date% %time%
echo.
pause