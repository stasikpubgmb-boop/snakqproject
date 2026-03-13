package com.snakq.client.module.impl.visual;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
public class NoFog extends Module {
    public NoFog() { 
        super("NoFog", Category.VISUAL); 
    }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions options = mc.options;
        options.fogDensity = 0;
    }
    @Override public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions options = mc.options;
        options.fogDensity = 1;
    }
}
