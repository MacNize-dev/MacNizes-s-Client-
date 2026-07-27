package com.macnize.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Client Configuration Manager
 * Gerencia todas as configurações do cliente
 */
public class ClientConfig {
    private static final Logger LOGGER = LogManager.getLogger("ClientConfig");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_DIR = new File("macs-client");
    private static final File CONFIG_FILE = new File(CONFIG_DIR, "config.json");
    
    private static Map<String, Object> config;
    
    static {
        config = new HashMap<>();
        setupDefaults();
    }
    
    public static void setupDefaults() {
        // Performance Settings
        setDefault("performance.fps.booster.enabled", true);
        setDefault("performance.fps.booster.level", 3);
        setDefault("performance.memory.auto.manage", true);
        setDefault("performance.memory.max.mb", 2048);
        setDefault("performance.render.distance", 16);
        setDefault("performance.entity.limit", 256);
        
        // Graphics Settings
        setDefault("graphics.shader.enabled", false);
        setDefault("graphics.shader.quality", "medium");
        setDefault("graphics.dynamic.lights", true);
        setDefault("graphics.particles", true);
        setDefault("graphics.fog.enabled", true);
        setDefault("graphics.fog.distance", 64);
        setDefault("graphics.vsync", false);
        setDefault("graphics.animation.speed", 1.0);
        
        // Mobile Settings
        setDefault("mobile.mode", true);
        setDefault("mobile.low.memory.mode", false);
        setDefault("mobile.cpu.throttle", false);
        setDefault("mobile.battery.saver", false);
        setDefault("mobile.touch.optimization", true);
        
        // Gameplay Settings
        setDefault("gameplay.hit.reticle", true);
        setDefault("gameplay.timer.multiplier", 1.0);
        
        // Utility Settings
        setDefault("utility.discord.rpc", true);
        setDefault("utility.screenshot.auto.upload", false);
        setDefault("utility.settings.sync", true);
        setDefault("utility.auto.update", true);
        
        // UI Settings
        setDefault("ui.theme", "dark");
        setDefault("ui.scale", 1.0);
        setDefault("ui.animation", true);
        setDefault("ui.notification.enabled", true);
    }
    
    private static void setDefault(String key, Object value) {
        if (!config.containsKey(key)) {
            config.put(key, value);
        }
    }
    
    public static void load() {
        try {
            // Create config directory if not exists
            if (!CONFIG_DIR.exists()) {
                CONFIG_DIR.mkdirs();
                LOGGER.info("📁 Diretório de configuração criado: " + CONFIG_DIR.getAbsolutePath());
            }
            
            // Load existing config or create new one
            if (CONFIG_FILE.exists()) {
                try (FileReader reader = new FileReader(CONFIG_FILE)) {
                    Map<String, Object> loadedConfig = gson.fromJson(reader, Map.class);
                    if (loadedConfig != null) {
                        config.putAll(loadedConfig);
                        LOGGER.info("✅ Configuração carregada de: " + CONFIG_FILE.getAbsolutePath());
                    }
                }
            } else {
                save();
            }
            
        } catch (IOException e) {
            LOGGER.error("❌ Erro ao carregar configuração", e);
        }
    }
    
    public static void save() {
        try {
            if (!CONFIG_DIR.exists()) {
                CONFIG_DIR.mkdirs();
            }
            
            try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
                gson.toJson(config, writer);
                LOGGER.info("✅ Configuração salva em: " + CONFIG_FILE.getAbsolutePath());
            }
            
        } catch (IOException e) {
            LOGGER.error("❌ Erro ao salvar configuração", e);
        }
    }
    
    public static boolean getBoolean(String key) {
        Object value = config.get(key);
        return value instanceof Boolean ? (Boolean) value : false;
    }
    
    public static int getInt(String key) {
        Object value = config.get(key);
        return value instanceof Number ? ((Number) value).intValue() : 0;
    }
    
    public static double getDouble(String key) {
        Object value = config.get(key);
        return value instanceof Number ? ((Number) value).doubleValue() : 0.0;
    }
    
    public static String getString(String key) {
        Object value = config.get(key);
        return value != null ? value.toString() : "";
    }
    
    public static void setBoolean(String key, boolean value) {
        config.put(key, value);
    }
    
    public static void setInt(String key, int value) {
        config.put(key, value);
    }
    
    public static void setDouble(String key, double value) {
        config.put(key, value);
    }
    
    public static void setString(String key, String value) {
        config.put(key, value);
    }
    
    public static Object get(String key) {
        return config.get(key);
    }
    
    public static Map<String, Object> getAll() {
        return new HashMap<>(config);
    }
    
    public static void reset() {
        config.clear();
        setupDefaults();
        save();
        LOGGER.info("♻️ Configurações resetadas para padrão");
    }
}