package com.snakq.client.module.impl.movement;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
public class Speed extends Module {
    public Speed() { 
        super("Speed", Category.MOVEMENT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||!isEnabled()) return;
        mc.player.setVelocity(mc.player.getVelocity().multiply(1.5,1.0,1.5));
    }
}
