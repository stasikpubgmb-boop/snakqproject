package com.snakq.client.module.impl.combat;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class KillAura extends Module {

    private final float rotationSpeed = 10.0f;
    private final float attackSpeed = 8.0f;

    public KillAura() {
        super("KillAura", Category.COMBAT);
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
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return;
        }

        Entity target = findNearestPlayer(player);
        if (target == null) {
            return;
        }

        float angle = getAngleToTarget(player, target);
        player.setYaw(player.getYaw() + angle);

        if (shouldAttack(player, target)) {
            player.attack();
        }
    }

    private Entity findNearestPlayer(ClientPlayerEntity player) {
        double nearestDistance = Double.MAX_VALUE;
        Entity nearestPlayer = null;

        for (Entity entity : player.world.getEntities()) {
            if (entity instanceof PlayerEntity && entity != player) {
                double distance = player.distanceTo(entity);
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestPlayer = entity;
                }
            }
        }

        return nearestPlayer;
    }

    private float getAngleToTarget(ClientPlayerEntity player, Entity target) {
        Vec3d playerPos = player.getPos();
        Vec3d targetPos = target.getPos();

        float yaw = (float) MathHelper.atan2(targetPos.z - playerPos.z, targetPos.x - playerPos.x);
        yaw = (float) (yaw * 180 / Math.PI);

        float angle = yaw - player.getYaw();
        if (angle > 180) {
            angle -= 360;
        } else if (angle < -180) {
            angle += 360;
        }

        return angle / rotationSpeed;
    }

    private boolean shouldAttack(ClientPlayerEntity player, Entity target) {
        return player.distanceTo(target) < 4.0 && System.currentTimeMillis() % (1000 / attackSpeed) == 0;
    }
}

