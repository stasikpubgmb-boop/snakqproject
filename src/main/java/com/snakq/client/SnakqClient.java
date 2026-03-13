package com.snakq.client;

import net.fabricmc.api.ModInitializer;
import com.snakq.client.module.ModuleManager;

public class SnakqClient implements ModInitializer {

    private final ModuleManager moduleManager = new ModuleManager();

    @Override
    public void onInitialize() {
        moduleManager.init();
    }
}
