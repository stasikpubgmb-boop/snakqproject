package com.snakq.client.module.impl.movement;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(Dist.CLIENT)
public class NoFallMod extends Module {
    public NoFallMod() { 
        super("NoFall", Category.MOVEMENT); 
    }
    @SubscribeEvent
    public void onPlayerTick(PlayerEvent.PlayerTickEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        PlayerEntity player = mc.player;
        if (isEnabled()) {
            // Prevent fall damage
            mc.player.fallDistance = 0;
        }
    }
}
