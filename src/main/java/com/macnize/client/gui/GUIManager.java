package com.macnize.client.gui;

import com.macnize.client.ClientConfig;
import com.macnize.client.MacsClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Main GUI Manager
 * Gerencia todas as telas da GUI
 */
public class GUIManager {
    private static final Logger LOGGER = LogManager.getLogger("GUIManager");
    private static JFrame mainFrame;
    private static MainMenuPanel mainMenuPanel;
    private static SettingsPanel settingsPanel;
    private static ModulesPanel modulesPanel;
    private static boolean guiVisible = false;
    
    public static void initialize() {
        try {
            LOGGER.info("🎨 Inicializando GUI Manager...");
            
            // Set Look and Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Create main frame
            mainFrame = new JFrame("MacNize's Client v" + MacsClient.getVersion());
            mainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            mainFrame.setSize(900, 600);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setResizable(false);
            mainFrame.setIconImage(getIcon());
            
            // Create panels
            mainMenuPanel = new MainMenuPanel();
            settingsPanel = new SettingsPanel();
            modulesPanel = new ModulesPanel();
            
            // Set main menu as default
            mainFrame.setContentPane(mainMenuPanel);
            mainFrame.setVisible(false);
            
            LOGGER.info("✅ GUI Manager inicializado com sucesso");
            
        } catch (Exception e) {
            LOGGER.error("❌ Erro ao inicializar GUI", e);
        }
    }
    
    public static void toggleVisibility() {
        if (guiVisible) {
            mainFrame.setVisible(false);
            guiVisible = false;
        } else {
            mainFrame.setVisible(true);
            guiVisible = true;
        }
    }
    
    public static void showMainMenu() {
        mainFrame.setContentPane(mainMenuPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public static void showSettings() {
        mainFrame.setContentPane(settingsPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public static void showModules() {
        mainFrame.setContentPane(modulesPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public static JFrame getMainFrame() {
        return mainFrame;
    }
    
    public static boolean isGuiVisible() {
        return guiVisible;
    }
    
    private static Image getIcon() {
        // Create a default icon
        BufferedImage image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(40, 200, 240));
        g2d.fillRect(0, 0, 64, 64);
        g2d.setColor(new Color(255, 255, 255));
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.drawString("M", 15, 50);
        g2d.dispose();
        return image;
    }
}
