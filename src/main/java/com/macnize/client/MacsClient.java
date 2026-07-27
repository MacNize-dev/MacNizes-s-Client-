package com.macnize.client;

import net.minecraft.client.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * MacNize's Client - Main Entry Point
 * Minecraft 1.12.2 Ultra-Optimized Client for Mobile
 */
public class MacsClient {
    private static final Logger LOGGER = LogManager.getLogger("MacNize's Client");
    private static final String VERSION = "1.0.0";
    private static final String MC_VERSION = "1.12.2";
    
    public static void main(String[] args) {
        LOGGER.info("========================================");
        LOGGER.info("🎮 MacNize's Client v" + VERSION);
        LOGGER.info("Minecraft " + MC_VERSION);
        LOGGER.info("Otimizado para Mobile");
        LOGGER.info("========================================");
        
        // Initialize client
        initialize();
        
        // Launch Minecraft
        launchMinecraft(args);
    }
    
    private static void initialize() {
        try {
            LOGGER.info("Inicializando MacNize's Client...");
            
            // Load configuration
            ClientConfig.load();
            LOGGER.info("✅ Configuração carregada");
            
            // Initialize modules
            ModuleManager.initialize();
            LOGGER.info("✅ Módulos inicializados");
            
            // Apply optimizations
            MobileOptimization.applyOptimizations();
            LOGGER.info("✅ Otimizações mobile aplicadas");
            
            LOGGER.info("✅ Cliente pronto para iniciar!");
            
        } catch (Exception e) {
            LOGGER.error("❌ Erro ao inicializar cliente", e);
            System.exit(1);
        }
    }
    
    private static void launchMinecraft(String[] args) {
        try {
            LOGGER.info("Iniciando Minecraft 1.12.2...");
            Main.main(args);
        } catch (Exception e) {
            LOGGER.error("❌ Erro ao iniciar Minecraft", e);
            System.exit(1);
        }
    }
    
    public static String getVersion() {
        return VERSION;
    }
    
    public static String getMcVersion() {
        return MC_VERSION;
    }
}