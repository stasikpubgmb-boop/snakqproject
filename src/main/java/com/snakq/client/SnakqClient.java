package com.snakq.client;

import com.snakq.client.config.ConfigManager;
import com.snakq.client.event.EventBus;
import com.snakq.client.gui.ClickGUI;
import com.snakq.client.gui.HUD;
import com.snakq.client.module.ModuleManager;
import net.fabricmc.api.ModInitializer;

public class SnakqClient implements ModInitializer {

    private final ModuleManager moduleManager = new ModuleManager();
    private final HUD hud = new HUD(moduleManager);
    private final ClickGUI clickGUI = new ClickGUI(moduleManager);
    private final EventBus eventBus = new EventBus();
    private final ConfigManager configManager = new ConfigManager();

    @Override
    public void onInitialize() {
        moduleManager.init();
        configManager.load();

        // register events
        // eventBus.register(new EventListener());
    }
}
