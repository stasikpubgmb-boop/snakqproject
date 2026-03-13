package com.snakq.client.module.impl.movement;

import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.player.PlayerEntity;

public class Speed extends Module {
    public Speed() {
        super("Speed", Category.MOVEMENT);
    }

    @Override
    public void tick() {
        // Implementation of Speed
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player != null && player.isAlive() && this.isEnabled()) {
            // Increase player speed
            GameOptions options = client.options;
            options.speed = 10.0f;
        }
    }
}
