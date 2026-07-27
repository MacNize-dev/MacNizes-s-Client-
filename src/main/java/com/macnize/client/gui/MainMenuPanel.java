package com.macnize.client.gui;

import com.macnize.client.MacsClient;
import com.macnize.client.ClientConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 * Main Menu Panel
 * Tela inicial da GUI
 */
public class MainMenuPanel extends JPanel implements ActionListener {
    private JButton playButton;
    private JButton settingsButton;
    private JButton modulesButton;
    private JButton creditsButton;
    private JButton exitButton;
    private JLabel versionLabel;
    private JLabel statusLabel;
    
    public MainMenuPanel() {
        setLayout(null);
        setBackground(new Color(20, 20, 30));
        initializeComponents();
    }
    
    private void initializeComponents() {
        // Title
        JLabel titleLabel = new JLabel("MacNize's Client");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(new Color(40, 200, 240));
        titleLabel.setBounds(150, 50, 600, 80);
        add(titleLabel);
        
        // Subtitle
        JLabel subtitleLabel = new JLabel("Minecraft 1.12.2 - Ultra Otimizado para Mobile");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitleLabel.setForeground(new Color(150, 150, 150));
        subtitleLabel.setBounds(150, 130, 600, 30);
        add(subtitleLabel);
        
        // Play Button
        playButton = createStyledButton("Jogar", 150, 200, 600, 50);
        playButton.addActionListener(e -> playGame());
        add(playButton);
        
        // Settings Button
        settingsButton = createStyledButton("⚙️ Configurações", 150, 270, 600, 50);
        settingsButton.addActionListener(e -> GUIManager.showSettings());
        add(settingsButton);
        
        // Modules Button
        modulesButton = createStyledButton("📦 Módulos", 150, 340, 600, 50);
        modulesButton.addActionListener(e -> GUIManager.showModules());
        add(modulesButton);
        
        // Credits Button
        creditsButton = createStyledButton("❓ Créditos", 150, 410, 280, 50);
        creditsButton.addActionListener(e -> showCredits());
        add(creditsButton);
        
        // Exit Button
        exitButton = createStyledButton("❌ Sair", 470, 410, 280, 50);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
        
        // Version Label
        versionLabel = new JLabel("v" + MacsClient.getVersion());
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        versionLabel.setForeground(new Color(100, 100, 100));
        versionLabel.setBounds(10, 550, 100, 30);
        add(versionLabel);
        
        // Status Label
        statusLabel = new JLabel("✅ Pronto para iniciar");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(100, 200, 100));
        statusLabel.setBounds(750, 550, 130, 30);
        add(statusLabel);
    }
    
    private JButton createStyledButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(40, 200, 240));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 220, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(40, 200, 240));
            }
        });
        
        return button;
    }
    
    private void playGame() {
        JOptionPane.showMessageDialog(this,
            "O jogo será iniciado com as otimizações aplicadas!",
            "Iniciando Minecraft",
            JOptionPane.INFORMATION_MESSAGE);
        GUIManager.getMainFrame().setVisible(false);
    }
    
    private void showCredits() {
        String credits = "MacNize's Client v" + MacsClient.getVersion() + "\n\n" +
                "Desenvolvido por: MacNize-dev\n" +
                "Minecraft Version: 1.12.2\n\n" +
                "Inspirado em:\n" +
                "• Lunar Client\n" +
                "• Badlion Client\n" +
                "• Feather Client\n\n" +
                "Otimizado para Mobile!";
        
        JOptionPane.showMessageDialog(this, credits, "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw decorative background
        g2d.setColor(new Color(30, 30, 40));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
