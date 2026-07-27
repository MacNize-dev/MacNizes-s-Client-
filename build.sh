#!/bin/bash
# Build script for MacNize's Client

echo "========================================"
echo "MacNize's Client - Build Script"
echo "========================================"
echo ""

# Check Java
if ! command -v java &> /dev/null; then
    echo "❌ Java não encontrado. Instale Java 11+"
    exit 1
fi

echo "✅ Java encontrado"
java -version
echo ""

# Clean
echo "🧹 Limpando build anterior..."
./gradlew clean

# Build
echo "🔨 Compilando projeto..."
./gradlew build

if [ $? -ne 0 ]; then
    echo "❌ Erro ao compilar"
    exit 1
fi

echo "✅ Compilação concluída"

# Create Universal JAR
echo "📦 Criando JAR universal..."
./gradlew buildUniversalJar

if [ $? -ne 0 ]; then
    echo "❌ Erro ao criar JAR"
    exit 1
fi

echo ""
echo "========================================"
echo "✅ BUILD CONCLUÍDO COM SUCESSO!"
echo "========================================"
echo ""
echo "📁 Arquivo gerado em:"
echo "   build/libs/MacNizes-Client-1.0.0.jar"
echo ""
echo "📥 Para instalar:"
echo "   PojavLauncher: Settings → Custom Mods → Import .jar"
echo "   ZalithLauncher: Copie para /sdcard/ZalithLauncher/mods/"
echo ""
echo "🎮 Divirta-se jogando!"
echo "========================================"
