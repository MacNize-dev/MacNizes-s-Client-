package com.macnize.client.modules;

import com.macnize.client.ClientConfig;
import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Memory Manager Module
 * Gerenciamento automático e inteligente de memória
 */
public class MemoryManagerModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("MemoryManager");
    private long lastMemoryCheck = 0;
    private static final long MEMORY_CHECK_INTERVAL = 5000; // 5 segundos
    private static final float MEMORY_THRESHOLD = 0.85f; // 85%
    
    @Override
    public void onEnable() {
        super.onEnable();
        LOGGER.info("💾 Memory Manager ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Memory Manager desativado");
    }
    
    @Override
    public void onTick() {
        if (!enabled) return;
        
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastMemoryCheck >= MEMORY_CHECK_INTERVAL) {
            checkAndOptimizeMemory();
            lastMemoryCheck = currentTime;
        }
    }
    
    private void checkAndOptimizeMemory() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long usedMemory = totalMemory - runtime.freeMemory();
        float memoryUsagePercent = (float) usedMemory / maxMemory;
        
        if (memoryUsagePercent > MEMORY_THRESHOLD) {
            LOGGER.warn("⚠️ Memória alta (" + String.format("%.1f%%", memoryUsagePercent * 100) + "). Executando garbage collection...");
            System.gc();
        } else {
            LOGGER.debug("💾 Uso de memória: " + String.format("%.1f%%", memoryUsagePercent * 100));
        }
    }
    
    public long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    
    public long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }
    
    public float getMemoryUsagePercent() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long usedMemory = totalMemory - runtime.freeMemory();
        return (float) usedMemory / maxMemory;
    }
    
    @Override
    public String getDescription() {
        return "Gerencia automática de memória com coleta de lixo inteligente";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}