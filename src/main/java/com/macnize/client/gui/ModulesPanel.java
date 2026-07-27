package com.macnize.client.gui;

import com.macnize.client.ModuleManager;

import javax.swing.*;
import java.awt.*;

/**
 * Modules Panel
 * Painel para gerenciar módulos
 */
public class ModulesPanel extends JPanel {
    private JList<String> moduleList;
    private JTextArea descriptionArea;
    private JButton enableButton;
    private JButton disableButton;
    private JButton backButton;
    private DefaultListModel<String> listModel;
    
    public ModulesPanel() {
        setLayout(null);
        setBackground(new Color(20, 20, 30));
        initializeComponents();
    }
    
    private void initializeComponents() {
        // Title
        JLabel titleLabel = new JLabel("📦 Módulos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(40, 200, 240));
        titleLabel.setBounds(30, 20, 400, 50);
        add(titleLabel);
        
        // Module List
        listModel = new DefaultListModel<>();
        ModuleManager.getAllModules().keySet().forEach(listModel::addElement);
        
        moduleList = new JList<>(listModel);
        moduleList.setBackground(new Color(30, 30, 40));
        moduleList.setForeground(new Color(200, 200, 200));
        moduleList.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(moduleList);
        scrollPane.setBounds(30, 80, 350, 400);
        add(scrollPane);
        
        // Description Area
        JLabel descLabel = new JLabel("Descrição:");
        descLabel.setFont(new Font("Arial", Font.BOLD, 12));
        descLabel.setForeground(new Color(200, 200, 200));
        descLabel.setBounds(400, 80, 200, 30);
        add(descLabel);
        
        descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(new Color(30, 30, 40));
        descriptionArea.setForeground(new Color(200, 200, 200));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        descScrollPane.setBounds(400, 110, 450, 370);
        add(descScrollPane);
        
        // Module selection listener
        moduleList.addListSelectionListener(e -> updateDescription());
        
        // Enable Button
        enableButton = createButton("✅ Ativar", 30, 500);
        enableButton.addActionListener(e -> enableModule());
        add(enableButton);
        
        // Disable Button
        disableButton = createButton("⛔ Desativar", 200, 500);
        disableButton.addActionListener(e -> disableModule());
        add(disableButton);
        
        // Back Button
        backButton = createButton("⬅️ Voltar", 370, 500);
        backButton.addActionListener(e -> GUIManager.showMainMenu());
        add(backButton);
    }
    
    private void updateDescription() {
        String selectedModule = moduleList.getSelectedValue();
        if (selectedModule != null) {
            ModuleManager.IModule module = ModuleManager.getModule(selectedModule);
            if (module != null) {
                descriptionArea.setText(
                    "Nome: " + module.getName() + "\n" +
                    "Status: " + (module.isEnabled() ? "✅ Ativo" : "❌ Inativo") + "\n" +
                    "Versão: " + module.getVersion() + "\n\n" +
                    "Descrição:\n" + module.getDescription()
                );
            }
        }
    }
    
    private void enableModule() {
        String selectedModule = moduleList.getSelectedValue();
        if (selectedModule != null) {
            ModuleManager.enableModule(selectedModule);
            updateDescription();
            JOptionPane.showMessageDialog(this, "✅ Módulo " + selectedModule + " ativado!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void disableModule() {
        String selectedModule = moduleList.getSelectedValue();
        if (selectedModule != null) {
            ModuleManager.disableModule(selectedModule);
            updateDescription();
            JOptionPane.showMessageDialog(this, "⛔ Módulo " + selectedModule + " desativado!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(40, 200, 240));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
