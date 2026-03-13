package com.snakq.client.module.impl.misc;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
public class FastPlace extends Module {
    public FastPlace() { 
        super("FastPlace", Category.MISC); 
    }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions options = mc.options;
        options.buildDistance = 0;
    }
    @Override public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions options = mc.options;
        options.buildDistance = 4;
    }
}
