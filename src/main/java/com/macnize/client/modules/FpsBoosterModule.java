package com.macnize.client.modules;

import com.macnize.client.ClientConfig;
import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FPS Booster Module
 * Otimização agressiva de renderização para aumentar FPS
 */
public class FpsBoosterModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("FpsBooster");
    private int boostLevel = 3;
    private long lastOptimization = 0;
    private static final long OPTIMIZATION_INTERVAL = 1000; // 1 segundo
    
    @Override
    public void onEnable() {
        super.onEnable();
        boostLevel = ClientConfig.getInt("performance.fps.booster.level");
        LOGGER.info("🚀 FPS Booster ativado - Nível " + boostLevel);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 FPS Booster desativado");
    }
    
    @Override
    public void onTick() {
        if (!enabled) return;
        
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastOptimization >= OPTIMIZATION_INTERVAL) {
            applyOptimizations();
            lastOptimization = currentTime;
        }
    }
    
    private void applyOptimizations() {
        switch (boostLevel) {
            case 1:
                applyLightBoost();
                break;
            case 2:
                applyMediumBoost();
                break;
            case 3:
                applyNormalBoost();
                break;
            case 4:
                applyAgressiveBoost();
                break;
            case 5:
                applyMaxBoost();
                break;
        }
    }
    
    private void applyLightBoost() {
        // Light optimizations
        System.setProperty("java.awt.headless", "true");
    }
    
    private void applyMediumBoost() {
        // Medium optimizations
        System.setProperty("sun.java2d.transaccel", "true");
    }
    
    private void applyNormalBoost() {
        // Normal optimizations
        System.setProperty("sun.java2d.d3d", "false");
    }
    
    private void applyAgressiveBoost() {
        // Aggressive optimizations
        System.setProperty("sun.java2d.opengl", "true");
    }
    
    private void applyMaxBoost() {
        // Maximum optimizations
        System.setProperty("java.awt.headless", "true");
        System.setProperty("sun.java2d.transaccel", "true");
        System.setProperty("sun.java2d.opengl", "true");
    }
    
    public void setBoostLevel(int level) {
        if (level >= 1 && level <= 5) {
            boostLevel = level;
            ClientConfig.setInt("performance.fps.booster.level", level);
            ClientConfig.save();
        }
    }
    
    @Override
    public String getDescription() {
        return "Aumenta FPS através de otimizações agressivas de renderização";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}