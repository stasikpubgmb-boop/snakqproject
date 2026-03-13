package com.snakq.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class SnakqClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.startTickEvent().register(client -> {
            // Initialize your mod here
            ModuleManager.init();
        });
    }
}
