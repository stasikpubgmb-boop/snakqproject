package com.snakq.client.module.impl.movement;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class BunnyHop extends Module {
    public BunnyHop() { 
        super("BunnyHop", Category.MOVEMENT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        PlayerEntity player = mc.player;
        if(player.isOnGround()) {
            player.jump();
        }
    }
}
