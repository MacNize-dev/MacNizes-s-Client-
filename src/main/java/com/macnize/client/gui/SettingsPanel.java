package com.macnize.client.gui;

import com.macnize.client.ClientConfig;
import com.macnize.client.MobileOptimization;

import javax.swing.*;
import java.awt.*;

/**
 * Settings Panel
 * Painel de configurações
 */
public class SettingsPanel extends JPanel {
    private JSlider fpsBoosterSlider;
    private JSlider renderDistanceSlider;
    private JComboBox<String> deviceProfileCombo;
    private JCheckBox dynamicLightsCheck;
    private JCheckBox particlesCheck;
    private JCheckBox shadersCheck;
    private JCheckBox batterySaverCheck;
    private JButton backButton;
    private JButton applyButton;
    private JButton resetButton;
    
    public SettingsPanel() {
        setLayout(null);
        setBackground(new Color(20, 20, 30));
        initializeComponents();
    }
    
    private void initializeComponents() {
        // Title
        JLabel titleLabel = new JLabel("⚙️ Configurações");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(40, 200, 240));
        titleLabel.setBounds(30, 20, 400, 50);
        add(titleLabel);
        
        int yPos = 100;
        int labelWidth = 200;
        int componentWidth = 250;
        int componentHeight = 30;
        
        // Device Profile
        add(createLabel("Perfil do Dispositivo:", 30, yPos));
        deviceProfileCombo = new JComboBox<>(new String[]{"Low-End (2GB)", "Mid-Range (4GB)", "High-End (8GB+)"});
        deviceProfileCombo.setBounds(30 + labelWidth, yPos, componentWidth, componentHeight);
        add(deviceProfileCombo);
        yPos += 50;
        
        // FPS Booster
        add(createLabel("FPS Booster (1-5):", 30, yPos));
        fpsBoosterSlider = new JSlider(1, 5, ClientConfig.getInt("performance.fps.booster.level"));
        fpsBoosterSlider.setBounds(30 + labelWidth, yPos, componentWidth, componentHeight);
        fpsBoosterSlider.setMajorTickSpacing(1);
        fpsBoosterSlider.setPaintTicks(true);
        fpsBoosterSlider.setPaintLabels(true);
        add(fpsBoosterSlider);
        yPos += 50;
        
        // Render Distance
        add(createLabel("Distância de Renderização:", 30, yPos));
        renderDistanceSlider = new JSlider(8, 32, ClientConfig.getInt("performance.render.distance"));
        renderDistanceSlider.setBounds(30 + labelWidth, yPos, componentWidth, componentHeight);
        renderDistanceSlider.setMajorTickSpacing(4);
        renderDistanceSlider.setPaintTicks(true);
        renderDistanceSlider.setPaintLabels(true);
        add(renderDistanceSlider);
        yPos += 50;
        
        // Dynamic Lights
        dynamicLightsCheck = createCheckBox("Luzes Dinâmicas", 30, yPos,
            ClientConfig.getBoolean("graphics.dynamic.lights"));
        add(dynamicLightsCheck);
        yPos += 40;
        
        // Particles
        particlesCheck = createCheckBox("Partículas", 30, yPos,
            ClientConfig.getBoolean("graphics.particles"));
        add(particlesCheck);
        yPos += 40;
        
        // Shaders
        shadersCheck = createCheckBox("Suporte a Shaders", 30, yPos,
            ClientConfig.getBoolean("graphics.shader.enabled"));
        add(shadersCheck);
        yPos += 40;
        
        // Battery Saver
        batterySaverCheck = createCheckBox("Modo Econômico", 30, yPos,
            ClientConfig.getBoolean("mobile.battery.saver"));
        add(batterySaverCheck);
        yPos += 50;
        
        // Buttons
        applyButton = createButton("✅ Aplicar", 30, yPos);
        applyButton.addActionListener(e -> applySettings());
        add(applyButton);
        
        resetButton = createButton("🔄 Resetar", 250, yPos);
        resetButton.addActionListener(e -> resetSettings());
        add(resetButton);
        
        backButton = createButton("⬅️ Voltar", 470, yPos);
        backButton.addActionListener(e -> GUIManager.showMainMenu());
        add(backButton);
    }
    
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(new Color(200, 200, 200));
        label.setBounds(x, y, 200, 30);
        return label;
    }
    
    private JCheckBox createCheckBox(String text, int x, int y, boolean selected) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setSelected(selected);
        checkBox.setFont(new Font("Arial", Font.PLAIN, 12));
        checkBox.setForeground(new Color(200, 200, 200));
        checkBox.setBackground(new Color(20, 20, 30));
        checkBox.setBounds(x, y, 250, 30);
        return checkBox;
    }
    
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 40);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(40, 200, 240));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    private void applySettings() {
        ClientConfig.setInt("performance.fps.booster.level", fpsBoosterSlider.getValue());
        ClientConfig.setInt("performance.render.distance", renderDistanceSlider.getValue());
        ClientConfig.setBoolean("graphics.dynamic.lights", dynamicLightsCheck.isSelected());
        ClientConfig.setBoolean("graphics.particles", particlesCheck.isSelected());
        ClientConfig.setBoolean("graphics.shader.enabled", shadersCheck.isSelected());
        ClientConfig.setBoolean("mobile.battery.saver", batterySaverCheck.isSelected());
        ClientConfig.save();
        
        JOptionPane.showMessageDialog(this, "✅ Configurações aplicadas com sucesso!",
            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void resetSettings() {
        int result = JOptionPane.showConfirmDialog(this,
            "Deseja resetar todas as configurações para o padrão?",
            "Confirmar Reset", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            ClientConfig.reset();
            JOptionPane.showMessageDialog(this, "✅ Configurações resetadas!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
