package com.snakq.client.module.impl.visual;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.Options;
public class Fullbright extends Module {
    public Fullbright() { 
        super("Fullbright", Category.VISUAL); 
    }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Options options = mc.options;
        options.gamma = 10000;
    }
    @Override public void onDisable() {
        // Reset gamma on disable
        MinecraftClient mc = MinecraftClient.getInstance();
        Options options = mc.options;
        options.gamma = 1; // default gamma
    }
}
