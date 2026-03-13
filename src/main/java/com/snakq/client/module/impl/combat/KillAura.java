package com.snakq.client.module.impl.combat;

import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class KillAura extends Module {
    public KillAura() {
        super("KillAura", Category.COMBAT);
    }

    @Override
    public void tick() {
        // Implementation of KillAura
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player != null && player.isAlive()) {
            for (Entity entity : client.world.getEntities()) {
                if (entity instanceof PlayerEntity && entity != player) {
                    // Check distance and attack entity
                    double distance = player.getDistance(entity);
                    if (distance < 4.0) {
                        // Attack entity
                        player.attack(entity);
                    }
                }
            }
        }
    }
}
