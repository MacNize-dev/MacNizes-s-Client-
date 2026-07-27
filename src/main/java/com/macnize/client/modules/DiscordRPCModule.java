package com.macnize.client.modules;

import com.macnize.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Discord RPC Module
 * Integração com Discord Rich Presence
 */
public class DiscordRPCModule extends ModuleManager.Module {
    private static final Logger LOGGER = LogManager.getLogger("DiscordRPC");
    private String clientId = "1234567890123456";
    private String currentState = "Em um servidor";
    
    @Override
    public void onEnable() {
        super.onEnable();
        LOGGER.info("💬 Discord RPC ativado");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.info("🛑 Discord RPC desativado");
    }
    
    public void setCurrentState(String state) {
        currentState = state;
    }
    
    public String getCurrentState() {
        return currentState;
    }
    
    @Override
    public String getDescription() {
        return "Exibe status do jogo no Discord via Rich Presence";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
}