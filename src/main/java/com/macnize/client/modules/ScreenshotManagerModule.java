package com.macnize.client.modules;

import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Screenshot Manager Module
 * Gerencia capturas de tela
 */
public class ScreenshotManagerModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("ScreenshotManager");
    private static final File SCREENSHOT_DIR = new File("screenshots");
    
    @Override
    public void onEnable() {
        super.onEnable();
        if (!SCREENSHOT_DIR.exists()) {
            SCREENSHOT_DIR.mkdirs();
        }
        LOGGER.info("📷 Screenshot Manager ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Screenshot Manager desativado");
    }
    
    public String generateScreenshotName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        return "screenshot_" + sdf.format(new Date()) + ".png";
    }
    
    public File getScreenshotDirectory() {
        return SCREENSHOT_DIR;
    }
    
    @Override
    public String getDescription() {
        return "Gerenciador de capturas de tela com organização automática";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}