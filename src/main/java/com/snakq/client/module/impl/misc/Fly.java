package com.snakq.client.module.impl.misc;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class Fly extends Module {
    public Fly() { 
        super("Fly", Category.MISC); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        PlayerEntity player = mc.player;
        if(player.isOnGround()) {
            player.addVelocity(0, 1, 0);
        }
    }
}
