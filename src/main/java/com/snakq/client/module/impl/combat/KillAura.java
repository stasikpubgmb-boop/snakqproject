package com.snakq.client.module.impl.combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class KillAura extends Module {
    @Override
    public void onTick() {
        PlayerEntity player = PlayerEntity.getPlayerByName(client.getSession().getUsername());
        World world = player.world;

        for (Entity entity : world.getEntityComparator(entity -> true)) {
            // ...
        }
    }
}
