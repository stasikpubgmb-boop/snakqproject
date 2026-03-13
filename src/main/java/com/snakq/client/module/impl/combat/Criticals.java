package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class Criticals extends Module {
    public Criticals() { 
        super("Criticals", Category.COMBAT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        PlayerEntity player = mc.player;
        if(player.fallDistance > 0.5 && !player.isOnGround()) {
            player.addVelocity(0, 0.1, 0);
        }
    }
}
