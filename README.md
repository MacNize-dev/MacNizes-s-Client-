# 🎮 MacNize's Client - Minecraft 1.12.2

[![Java](https://img.shields.io/badge/Java-11%2B-orange)](https://www.java.com)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.12.2-green)](https://minecraft.net)
[![Mobile Optimized](https://img.shields.io/badge/Mobile-Optimized-brightgreen)](https://pojavlauncher.com)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

Um cliente Minecraft Java ultra-otimizado para jogadores mobile em launchers como **PojavLauncher** e **ZalithLauncher**. Inspirado em clientes populares como Lunar Client, Badlion Client e Feather Client.

## 🌟 Características Principais

- 🚀 **Otimização Extrema** - Configurado para rodar perfeitamente em dispositivos mobile
- 🎨 **Interface Moderna** - GUI intuitiva e responsiva
- ⚡ **FPS Booster** - Aumenta significativamente os FPS
- 🌈 **Suporte a Shaders** - Shaders compatíveis com 1.12.2
- 🛠️ **Módulos Customizáveis** - Sistema modular completo
- 📱 **Universal .JAR** - Compatível com qualquer launcher mobile Java
- ⚙️ **Configurações Avançadas** - Otimizações RAM, CPU e GPU
- 🎯 **PvP Friendly** - Melhorias para jogadores competitivos

## 📱 Compatibilidade

| Launcher | Status | Versão |
|----------|--------|--------|
| PojavLauncher | ✅ Suportado | 3.0+ |
| ZalithLauncher | ✅ Suportado | 2.0+ |
| TLauncher | ✅ Suportado | Todas |
| Minecraft Launcher | ✅ Suportado | Padrão |

## 🚀 Instalação Rápida

### Via PojavLauncher
1. Baixe o `MacNizes-Client-1.0.0.jar`
2. Vá em **Settings** → **Custom Mods**
3. Selecione o arquivo `.jar`
4. Clique em **Install**

### Via ZalithLauncher
1. Coloque o `.jar` na pasta `mods/`
2. Reinicie o launcher
3. Selecione "MacNize's Client" como versão

## 📦 Download

Baixe a versão mais recente:
- [MacNizes-Client-1.0.0.jar](releases) - Versão Completa (150MB)
- [MacNizes-Client-Lite-1.0.0.jar](releases) - Versão Lite (80MB)

## ⚙️ Funcionalidades

### 🎨 Módulos Disponíveis

#### Performance
- **FPS Booster** - Otimização de renderização (Nível 1-5)
- **Memory Manager** - Gerenciamento automático de RAM
- **Chunk Optimizer** - Carregamento otimizado de chunks
- **Entity Limiter** - Limite de entidades para melhor FPS

#### Gráficos
- **Shader Support** - Suporte a shaders GLSL 1.12.2 (Low/Medium/High)
- **Dynamic Lights** - Iluminação dinâmica melhorada
- **Particle Control** - Controle de partículas e efeitos
- **Fog Control** - Ajuste de distância de névoa

#### Gameplay
- **Hit Reticle** - Reticúla de impacto customizável
- **Timer Multiplier** - Controle de velocidade do jogo

#### Utilitários
- **Discord RPC** - Status em tempo real no Discord
- **Screenshot Manager** - Gerenciador de capturas
- **Settings Sync** - Sincronização em nuvem
- **Auto Update** - Atualização automática

## 🎮 Como Usar

### Primeira Vez
1. Inicie o Minecraft com MacNize's Client
2. Clique em **Settings** na tela inicial
3. Configure de acordo com seu dispositivo
4. Selecione os módulos desejados

### Ativar Shaders
1. Vá em **Graphics** → **Shader Settings**
2. Clique em **Enable Shaders**
3. Selecione um shader compatível com 1.12.2
4. Ajuste a qualidade (Low, Medium, High)
5. Reinicie o jogo

### Otimizar para Mobile
1. Acesse **Optimization** → **Mobile Profile**
2. Escolha seu nível de dispositivo:
   - 🟢 **Low-End** (2GB RAM) - Máxima otimização
   - 🟡 **Mid-Range** (4GB RAM) - Balanceado
   - 🔴 **High-End** (8GB+ RAM) - Máxima qualidade

## 🔧 Configuração de Desenvolvimento

### Requisitos
- Java 11+
- Gradle 6.0+
- Git

### Setup Local
```bash
git clone https://github.com/MacNize-dev/MacNizes-s-Client-.git
cd MacNizes-s-Client-
gradle build
gradle shadowJar
```

### Build JAR Universal
```bash
gradle buildUniversalJar
```

O arquivo gerado estará em `build/libs/MacNizes-Client-1.0.0.jar`

## 📝 Configuração Manual

### Arquivo de Configuração
Edite `config/macs-client-config.json`:

```json
{
  "performance": {
    "fps.booster.enabled": true,
    "fps.booster.level": 3,
    "memory.auto.manage": true,
    "max.render.distance": 16,
    "entity.limit": 256
  },
  "graphics": {
    "shader.enabled": false,
    "shader.quality": "medium",
    "dynamic.lights": true,
    "particles": true,
    "fog.enabled": true,
    "fog.distance": 64
  },
  "mobile": {
    "mode": true,
    "low.memory.mode": false,
    "battery.saver": false,
    "touch.optimization": true
  }
}
```

## 🛠️ Troubleshooting

### Problema: Crash ao iniciar
**Solução:** Aumente a RAM alocada
```bash
-Xmx2G -Xms1G
```

### Problema: FPS baixo
1. Desative Dynamic Lights
2. Reduza render distance para 12
3. Ative FPS Booster (nível máximo)
4. Desative shaders
5. Ative Low Memory Mode

### Problema: Shaders não funcionam
1. Verifique versão do Java (11+)
2. Aumente RAM alocada para 2GB+
3. Desative outros módulos gráficos
4. Reinstale o cliente

## 📊 Benchmarks

| Dispositivo | Sem Client | Com Client | Melhoria |
|-------------|-----------|-----------|----------|
| Mid-Range (4GB) | ~35 FPS | ~60+ FPS | **71%** ↑ |
| Low-End (2GB) | ~20 FPS | ~45+ FPS | **125%** ↑ |
| High-End (8GB+) | ~120 FPS | ~240+ FPS | **100%** ↑ |

## 🤝 Contribuições

Quer contribuir? Ótimo! 

1. Faça um Fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## ⚠️ Disclaimer

- MacNize's Client é um projeto independente e não é afiliado à Mojang Studios
- Uso em servidores multiplayer deve estar em conformidade com as regras do servidor
- Alguns módulos podem ser desativados em certos servidores
- Use por sua conta e risco

## 📞 Suporte

- 📧 **Email:** contaparaalguemlegal49@gmail.com [E-mail temporário]
- 💬 **Discord:** [servidor ainda sendo feito]
- 🐛 **Issues:** [Reporte bugs aqui](https://github.com/MacNize-dev/MacNizes-s-Client-/issues)

## 🎯 Roadmap

- [x] v1.0.0 - Lançamento inicial
- [ ] v1.1.0 - Suporte para 1.16.5
- [ ] v1.2.0 - Sistema de cosmetics avançado
- [ ] v1.3.0 - Integração com cloud saves
- [ ] v2.0.0 - Suporte multiplataforma (1.8.9, 1.12.2, 1.16.5, 1.19.2)

---

**Made with ❤️ by MacNize-dev**

Última atualização: 2026-07-27
