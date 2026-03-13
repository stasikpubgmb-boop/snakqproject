package com.snakq.client.module/impl/combat;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class Reach extends Module {

    private final double minReach = 3.0;
    private final double maxReach = 6.0;

    public Reach() {
        super("Reach", Category.COMBAT);
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
        if (client == null || client.player == null) {
            return;
        }

        Entity target = client.targetedEntity;
        if (target == null) {
            return;
        }

        double reach = Math.random() * (maxReach - minReach) + minReach;
        Vec3d targetPos = target.getPos();
        Vec3d playerPos = client.player.getPos();
        double distance = targetPos.distanceTo(playerPos);

        if (distance <= reach) {
            // Player is in range to attack
        }
    }
}

