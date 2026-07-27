package com.macnize.client.modules;

import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Timer Multiplier Module
 * Controla velocidade do jogo
 */
public class TimerMultiplierModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("TimerMultiplier");
    private double multiplier = 1.0;
    
    @Override
    public void onEnable() {
        super.onEnable();
        LOGGER.info("⏳ Timer Multiplier ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Timer Multiplier desativado");
    }
    
    public void setMultiplier(double mult) {
        multiplier = Math.max(0.5, Math.min(2.0, mult));
    }
    
    public double getMultiplier() {
        return multiplier;
    }
    
    @Override
    public String getDescription() {
        return "Altera a velocidade do jogo";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}