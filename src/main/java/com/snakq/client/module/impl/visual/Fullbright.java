package com.snakq.client.module.impl.visual;

import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class Fullbright extends Module {

    public Fullbright() {
        super("Fullbright", Category.VISUAL);
    }

    @Override
    public void onEnable() {
        MinecraftClient.getInstance().options.getGamma().setValue(10.0);
    }

    @Override
    public void onDisable() {
        // Reset gamma to default value
        MinecraftClient.getInstance().options.getGamma().setValue(0.0);
    }
}
