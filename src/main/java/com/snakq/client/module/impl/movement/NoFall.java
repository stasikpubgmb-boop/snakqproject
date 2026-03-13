package com.snakq.client.module.impl.movement;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class NoFall extends Module {
    public NoFall() { 
        super("NoFall", Category.MOVEMENT); 
    }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        mc.player.fallDistance = 0;
    }
    @Override public void onDisable() {
        // No need to reset fall distance on disable
    }
}
