package com.macnize.client.modules;

import com.macnize.client.ClientConfig;
import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Limiter Module
 * Limita número de entidades renderizadas para melhor FPS
 */
public class EntityLimiterModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("EntityLimiter");
    private int entityLimit = 256;
    
    @Override
    public void onEnable() {
        super.onEnable();
        entityLimit = ClientConfig.getInt("performance.entity.limit");
        LOGGER.info("🐠 Entity Limiter ativado - Limite: " + entityLimit);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Entity Limiter desativado");
    }
    
    @Override
    public void onTick() {
        if (!enabled) return;
        // Entity limiting logic
    }
    
    public void setEntityLimit(int limit) {
        entityLimit = Math.max(64, Math.min(1024, limit));
        ClientConfig.setInt("performance.entity.limit", entityLimit);
        ClientConfig.save();
    }
    
    public int getEntityLimit() {
        return entityLimit;
    }
    
    @Override
    public String getDescription() {
        return "Limita o número de entidades renderizadas para aumentar FPS";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}