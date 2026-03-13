package com.snakq.client.mod;

import com.snakq.client.SnakqClient;
import net.fabricmc.api.ModInitializer;

public class SnakqClientMod implements ModInitializer {

    @Override
    public void onInitialize() {
        new SnakqClient().onInitialize();
    }
}
