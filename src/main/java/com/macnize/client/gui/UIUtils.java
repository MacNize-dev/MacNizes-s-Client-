package com.macnize.client.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * UI Utilities
 * Utilitários para a interface gráfica
 */
public class UIUtils {
    
    /**
     * Criar um ícone arredondado
     */
    public static ImageIcon createRoundedIcon(Color color, int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.fillRoundRect(0, 0, size, size, 10, 10);
        g2d.dispose();
        return new ImageIcon(image);
    }
    
    /**
     * Criar um gradiente
     */
    public static void drawGradient(Graphics2D g2d, int x, int y, int width, int height,
                                   Color color1, Color color2) {
        GradientPaint gradient = new GradientPaint(x, y, color1, x + width, y + height, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(x, y, width, height);
    }
    
    /**
     * Tema escuro
     */
    public static class DarkTheme {
        public static final Color BACKGROUND = new Color(20, 20, 30);
        public static final Color SURFACE = new Color(30, 30, 40);
        public static final Color PRIMARY = new Color(40, 200, 240);
        public static final Color SECONDARY = new Color(60, 220, 255);
        public static final Color TEXT_PRIMARY = new Color(255, 255, 255);
        public static final Color TEXT_SECONDARY = new Color(150, 150, 150);
        public static final Color SUCCESS = new Color(100, 200, 100);
        public static final Color WARNING = new Color(255, 200, 100);
        public static final Color ERROR = new Color(255, 100, 100);
    }
    
    /**
     * Tema claro
     */
    public static class LightTheme {
        public static final Color BACKGROUND = new Color(240, 240, 245);
        public static final Color SURFACE = new Color(250, 250, 255);
        public static final Color PRIMARY = new Color(100, 150, 255);
        public static final Color SECONDARY = new Color(150, 180, 255);
        public static final Color TEXT_PRIMARY = new Color(20, 20, 30);
        public static final Color TEXT_SECONDARY = new Color(100, 100, 100);
        public static final Color SUCCESS = new Color(80, 180, 80);
        public static final Color WARNING = new Color(255, 180, 80);
        public static final Color ERROR = new Color(255, 80, 80);
    }
}
