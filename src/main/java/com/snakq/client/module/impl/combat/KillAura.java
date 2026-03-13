package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity; 
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
public class KillAura extends Module {
    public KillAura() { 
        super("KillAura", Category.COMBAT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        mc.world.getEntitiesByClass(LivingEntity.class, mc.player.getBoundingBox().expand(4), e -> e!=mc.player && !(e instanceof PlayerEntity)).stream().findFirst().ifPresent(e -> { 
            mc.player.swingHand(Hand.MAIN_HAND); 
            mc.interactionManager.attackEntity(mc.player,e); 
        });
    }
}
