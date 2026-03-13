package com.snakq.client.module.impl.combat;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

public class AutoClicker extends Module {

    private final int minCps = 8;
    private final int maxCps = 20;

    public AutoClicker() {
        super("AutoClicker", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        // Code to run when the module is enabled
    }

    @Override
    public void onDisable() {
        // Code to run when the module is disabled
    }

    public void update() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.options == null) {
            return;
        }

        GameOptions options = client.options;
        int clicksPerSecond = (int) (Math.random() * (maxCps - minCps + 1) + minCps);

        if (System.currentTimeMillis() % (1000 / clicksPerSecond) == 0) {
            options.attack = !options.attack;
        }
    }
}

