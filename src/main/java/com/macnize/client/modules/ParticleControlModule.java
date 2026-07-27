package com.macnize.client.modules;

import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Particle Control Module
 * Controle de partículas e efeitos visuais
 */
public class ParticleControlModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("ParticleControl");
    private float particleMultiplier = 1.0f;
    
    @Override
    public void onEnable() {
        super.onEnable();
        LOGGER.info("✨ Particle Control ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Particle Control desativado");
    }
    
    public void setParticleMultiplier(float multiplier) {
        particleMultiplier = Math.max(0.0f, Math.min(2.0f, multiplier));
    }
    
    public float getParticleMultiplier() {
        return particleMultiplier;
    }
    
    @Override
    public String getDescription() {
        return "Controla renderização de partículas para melhor desempenho";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}