package com.macnize.client.modules;

import com.macnize.client.ClientConfig;
import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Fog Control Module
 * Controla distância de névoa
 */
public class FogControlModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("FogControl");
    private int fogDistance = 64;
    
    @Override
    public void onEnable() {
        super.onEnable();
        fogDistance = ClientConfig.getInt("graphics.fog.distance");
        LOGGER.info("🌫️ Fog Control ativado - Distância: " + fogDistance);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Fog Control desativado");
    }
    
    public void setFogDistance(int distance) {
        fogDistance = Math.max(8, Math.min(256, distance));
        ClientConfig.setInt("graphics.fog.distance", fogDistance);
        ClientConfig.save();
    }
    
    public int getFogDistance() {
        return fogDistance;
    }
    
    @Override
    public String getDescription() {
        return "Controla distância de névoa para melhor visibilidade e desempenho";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}