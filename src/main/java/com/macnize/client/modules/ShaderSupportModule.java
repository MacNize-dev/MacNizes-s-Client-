package com.macnize.client.modules;

import com.macnize.client.ClientConfig;
import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Shader Support Module
 * Gerencia shaders compatíveis com 1.12.2
 */
public class ShaderSupportModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("ShaderSupport");
    private boolean shadersEnabled = false;
    private String activeShader = "none";
    private static final File SHADER_DIR = new File("macs-client/shaders");
    
    @Override
    public void onEnable() {
        super.onEnable();
        shadersEnabled = ClientConfig.getBoolean("graphics.shader.enabled");
        
        if (!SHADER_DIR.exists()) {
            SHADER_DIR.mkdirs();
            LOGGER.info("📁 Diretório de shaders criado");
        }
        
        LOGGER.info("🌈 Shader Support ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        shadersEnabled = false;
        LOGGER.info("🛑 Shader Support desativado");
    }
    
    @Override
    public void onTick() {
        if (!enabled) return;
    }
    
    public void enableShaders(String shaderName) {
        if (validateShader(shaderName)) {
            activeShader = shaderName;
            shadersEnabled = true;
            ClientConfig.setBoolean("graphics.shader.enabled", true);
            ClientConfig.setString("graphics.shader.active", shaderName);
            ClientConfig.save();
            LOGGER.info("✅ Shader ativado: " + shaderName);
        } else {
            LOGGER.warn("⚠️ Shader inválido: " + shaderName);
        }
    }
    
    public void disableShaders() {
        shadersEnabled = false;
        activeShader = "none";
        ClientConfig.setBoolean("graphics.shader.enabled", false);
        ClientConfig.save();
        LOGGER.info("🛑 Shaders desativados");
    }
    
    public void setShaderQuality(String quality) {
        if (quality.equals("low") || quality.equals("medium") || quality.equals("high")) {
            ClientConfig.setString("graphics.shader.quality", quality);
            ClientConfig.save();
            LOGGER.info("🌈 Qualidade de shader: " + quality);
        }
    }
    
    private boolean validateShader(String shaderName) {
        File shaderFile = new File(SHADER_DIR, shaderName + ".glsl");
        return shaderFile.exists();
    }
    
    public boolean isShadersEnabled() {
        return shadersEnabled;
    }
    
    public String getActiveShader() {
        return activeShader;
    }
    
    public String[] getAvailableShaders() {
        File[] files = SHADER_DIR.listFiles((dir, name) -> name.endsWith(".glsl"));
        if (files == null) return new String[0];
        
        String[] shaders = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            shaders[i] = files[i].getName().replace(".glsl", "");
        }
        return shaders;
    }
    
    @Override
    public String getDescription() {
        return "Suporte a shaders GLSL compatíveis com Minecraft 1.12.2";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}