package com.snakq.client.module.impl.misc;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
public class FastPlace extends Module {
    public FastPlace() { super("FastPlace", Category.MISC); }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        mc.player.getItemCooldownManager();
    }
}
