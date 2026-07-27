package com.macnize.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Mobile Optimization Handler
 * Aplica otimizações específicas para dispositivos móveis
 */
public class MobileOptimization {
    private static final Logger LOGGER = LogManager.getLogger("MobileOptimization");
    
    public static void applyOptimizations() {
        LOGGER.info("Aplicando otimizações para mobile...");
        
        String profile = detectDeviceProfile();
        LOGGER.info("Perfil de dispositivo detectado: " + profile);
        
        switch (profile) {
            case "LOW_END":
                applyLowEndOptimizations();
                break;
            case "MID_RANGE":
                applyMidRangeOptimizations();
                break;
            case "HIGH_END":
                applyHighEndOptimizations();
                break;
        }
    }
    
    private static String detectDeviceProfile() {
        long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        
        if (maxMemory <= 2048) {
            return "LOW_END";
        } else if (maxMemory <= 4096) {
            return "MID_RANGE";
        } else {
            return "HIGH_END";
        }
    }
    
    private static void applyLowEndOptimizations() {
        LOGGER.info("🟢 Aplicando otimizações para dispositivos LOW-END (≤2GB)...");
        
        ClientConfig.setBoolean("performance.fps.booster.enabled", true);
        ClientConfig.setInt("performance.fps.booster.level", 5);
        ClientConfig.setInt("performance.render.distance", 12);
        ClientConfig.setInt("performance.entity.limit", 128);
        ClientConfig.setBoolean("graphics.dynamic.lights", false);
        ClientConfig.setBoolean("graphics.fog.enabled", true);
        ClientConfig.setInt("graphics.fog.distance", 32);
        ClientConfig.setBoolean("graphics.shader.enabled", false);
        ClientConfig.setBoolean("performance.memory.auto.manage", true);
        ClientConfig.setInt("performance.memory.max.mb", 1024);
        ClientConfig.setBoolean("mobile.low.memory.mode", true);
        ClientConfig.setBoolean("mobile.battery.saver", true);
        ClientConfig.save();
        
        LOGGER.info("✅ Otimizações LOW-END aplicadas com sucesso");
    }
    
    private static void applyMidRangeOptimizations() {
        LOGGER.info("🟡 Aplicando otimizações para dispositivos MID-RANGE (4GB)...");
        
        ClientConfig.setBoolean("performance.fps.booster.enabled", true);
        ClientConfig.setInt("performance.fps.booster.level", 3);
        ClientConfig.setInt("performance.render.distance", 16);
        ClientConfig.setInt("performance.entity.limit", 256);
        ClientConfig.setBoolean("graphics.dynamic.lights", true);
        ClientConfig.setBoolean("graphics.fog.enabled", true);
        ClientConfig.setInt("graphics.fog.distance", 64);
        ClientConfig.setBoolean("graphics.shader.enabled", false);
        ClientConfig.setBoolean("performance.memory.auto.manage", true);
        ClientConfig.setInt("performance.memory.max.mb", 2048);
        ClientConfig.setBoolean("mobile.low.memory.mode", false);
        ClientConfig.setBoolean("mobile.battery.saver", false);
        ClientConfig.save();
        
        LOGGER.info("✅ Otimizações MID-RANGE aplicadas com sucesso");
    }
    
    private static void applyHighEndOptimizations() {
        LOGGER.info("🔴 Aplicando otimizações para dispositivos HIGH-END (8GB+)...");
        
        ClientConfig.setBoolean("performance.fps.booster.enabled", true);
        ClientConfig.setInt("performance.fps.booster.level", 1);
        ClientConfig.setInt("performance.render.distance", 32);
        ClientConfig.setInt("performance.entity.limit", 512);
        ClientConfig.setBoolean("graphics.dynamic.lights", true);
        ClientConfig.setBoolean("graphics.fog.enabled", true);
        ClientConfig.setInt("graphics.fog.distance", 128);
        ClientConfig.setBoolean("graphics.shader.enabled", true);
        ClientConfig.setString("graphics.shader.quality", "high");
        ClientConfig.setBoolean("performance.memory.auto.manage", true);
        ClientConfig.setInt("performance.memory.max.mb", 4096);
        ClientConfig.setBoolean("mobile.low.memory.mode", false);
        ClientConfig.setBoolean("mobile.battery.saver", false);
        ClientConfig.save();
        
        LOGGER.info("✅ Otimizações HIGH-END aplicadas com sucesso");
    }
    
    public static void enableBatterySaver() {
        LOGGER.info("Ativando modo economizador de bateria...");
        
        ClientConfig.setBoolean("mobile.battery.saver", true);
        ClientConfig.setBoolean("graphics.animation", false);
        ClientConfig.setBoolean("graphics.dynamic.lights", false);
        ClientConfig.setBoolean("ui.animation", false);
        ClientConfig.setInt("performance.render.distance", 12);
        ClientConfig.save();
        
        LOGGER.info("✅ Modo economizador de bateria ativado");
    }
    
    public static void enableMaxPerformance() {
        LOGGER.info("Ativando modo máxima performance...");
        
        ClientConfig.setBoolean("mobile.battery.saver", false);
        ClientConfig.setBoolean("performance.fps.booster.enabled", true);
        ClientConfig.setInt("performance.fps.booster.level", 5);
        ClientConfig.setBoolean("graphics.vsync", false);
        ClientConfig.save();
        
        LOGGER.info("✅ Modo máxima performance ativado");
    }
}