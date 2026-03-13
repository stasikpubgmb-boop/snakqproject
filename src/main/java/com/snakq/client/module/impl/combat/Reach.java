package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
public class Reach extends Module {
    private double reach = 3.0;
    public Reach() { 
        super("Reach", Category.COMBAT); 
    }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        mc.options.attackDistance = reach;
    }
    @Override public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        mc.options.attackDistance = 4.5;
    }
}
