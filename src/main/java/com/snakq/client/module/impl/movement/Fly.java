package com.snakq.client.module.impl.movement;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
public class Fly extends Module {
    public Fly() { super("Fly", Category.MOVEMENT); }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) { mc.player.getAbilities().allowFlying = true; mc.player.getAbilities().flying = true; }
    }
    @Override public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) { mc.player.getAbilities().allowFlying = false; mc.player.getAbilities().flying = false; }
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) mc.player.getAbilities().flying = true;
    }
}
