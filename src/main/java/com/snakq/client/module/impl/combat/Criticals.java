package com.snakq.client/module/impl/combat;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;

public class Criticals extends Module {

    public Criticals() {
        super("Criticals", Category.COMBAT);
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

        ClientPlayerEntity player = client.player;
        if (!(player instanceof PlayerEntity)) {
            return;
        }

        player.sendPlayerCommand(PlayerEntity.Abilities.FLYING) = true;
        client.player.networkHandler.sendPacket(new ClientCommandC2SPacket(ClientCommandC2SPacket.Mode.PRESS_SHIFT_KEY));
        // Send fake jump packets
    }
}

