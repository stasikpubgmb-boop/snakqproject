package com.snakq.client.module.impl.visual;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.WorldRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.awt.Color;
public class ESP extends Module {
    public ESP() { 
        super("ESP", Category.VISUAL); 
    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onWorldRender(WorldRenderEvent.Context context) {
        MinecraftClient mc = MinecraftClient.getInstance();
        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof LivingEntity) {
                Box box = entity.getBoundingBox();
                context.dispatcher.getWorld().drawShape(box, new Vec3d(0, 0, 0), new Color(255, 0, 0).getRGB());
            }
        }
    }
}
