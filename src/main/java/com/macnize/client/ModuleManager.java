package com.macnize.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Module Manager
 * Gerencia todos os módulos do cliente
 */
public class ModuleManager {
    private static final Logger LOGGER = LogManager.getLogger("ModuleManager");
    private static Map<String, IModule> modules = new HashMap<>();
    
    public static void initialize() {
        LOGGER.info("Inicializando módulos...");
        
        // Register Performance Modules
        registerModule("FpsBooster", new FpsBoosterModule());
        registerModule("MemoryManager", new MemoryManagerModule());
        registerModule("ChunkOptimizer", new ChunkOptimizerModule());
        registerModule("EntityLimiter", new EntityLimiterModule());
        
        // Register Graphics Modules
        registerModule("ShaderSupport", new ShaderSupportModule());
        registerModule("DynamicLights", new DynamicLightsModule());
        registerModule("ParticleControl", new ParticleControlModule());
        registerModule("FogControl", new FogControlModule());
        
        // Register Gameplay Modules
        registerModule("HitReticle", new HitReticleModule());
        registerModule("TimerMultiplier", new TimerMultiplierModule());
        
        // Register Utility Modules
        registerModule("DiscordRPC", new DiscordRPCModule());
        registerModule("ScreenshotManager", new ScreenshotManagerModule());
        
        LOGGER.info("✅ " + modules.size() + " módulos registrados");
        
        initializeEnabledModules();
    }
    
    private static void initializeEnabledModules() {
        modules.forEach((name, module) -> {
            try {
                if (ClientConfig.getBoolean("modules." + name + ".enabled")) {
                    module.onEnable();
                    LOGGER.info("✅ Módulo habilitado: " + name);
                }
            } catch (Exception e) {
                LOGGER.error("❌ Erro ao habilitar módulo: " + name, e);
            }
        });
    }
    
    private static void registerModule(String name, IModule module) {
        modules.put(name, module);
        module.setName(name);
        LOGGER.debug("Módulo registrado: " + name);
    }
    
    public static IModule getModule(String name) {
        return modules.get(name);
    }
    
    public static void enableModule(String name) {
        IModule module = modules.get(name);
        if (module != null && !module.isEnabled()) {
            module.onEnable();
            ClientConfig.setBoolean("modules." + name + ".enabled", true);
            ClientConfig.save();
            LOGGER.info("✅ Módulo habilitado: " + name);
        }
    }
    
    public static void disableModule(String name) {
        IModule module = modules.get(name);
        if (module != null && module.isEnabled()) {
            module.onDisable();
            ClientConfig.setBoolean("modules." + name + ".enabled", false);
            ClientConfig.save();
            LOGGER.info("⛔ Módulo desabilitado: " + name);
        }
    }
    
    public static void toggleModule(String name) {
        IModule module = modules.get(name);
        if (module != null) {
            if (module.isEnabled()) {
                disableModule(name);
            } else {
                enableModule(name);
            }
        }
    }
    
    public static Map<String, IModule> getAllModules() {
        return new HashMap<>(modules);
    }
    
    public static void onGameTick() {
        modules.values().forEach(module -> {
            if (module.isEnabled()) {
                module.onTick();
            }
        });
    }
    
    public static void shutdown() {
        LOGGER.info("Desligando módulos...");
        modules.values().forEach(IModule::onDisable);
        LOGGER.info("✅ Módulos desligados");
    }
    
    public interface IModule {
        void setName(String name);
        String getName();
        void onEnable();
        void onDisable();
        void onTick();
        boolean isEnabled();
        String getDescription();
        String getVersion();
    }
    
    public abstract static class Module implements IModule {
        protected String name;
        protected boolean enabled = false;
        
        @Override
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public boolean isEnabled() {
            return enabled;
        }
        
        @Override
        public void onEnable() {
            enabled = true;
        }
        
        @Override
        public void onDisable() {
            enabled = false;
        }
        
        @Override
        public void onTick() {
        }
    }
}