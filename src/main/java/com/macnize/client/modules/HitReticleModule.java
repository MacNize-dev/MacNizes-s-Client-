package com.macnize.client.modules;

import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hit Reticle Module
 * Reticúla de impacto customizável
 */
public class HitReticleModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("HitReticle");
    private boolean showOnHit = true;
    private String reticleStyle = "default";
    
    @Override
    public void onEnable() {
        super.onEnable();
        LOGGER.info("🌥️ Hit Reticle ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Hit Reticle desativado");
    }
    
    public void setReticleStyle(String style) {
        reticleStyle = style;
    }
    
    public String getReticleStyle() {
        return reticleStyle;
    }
    
    @Override
    public String getDescription() {
        return "Exibe reticúla de impacto durante combate";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}