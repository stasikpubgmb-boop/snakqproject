package com.snakq.client.module.impl.visual;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
public class NoFog extends Module {
    public NoFog() { super("NoFog", Category.VISUAL); }
    @Override public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.gameRenderer != null) mc.gameRenderer.setRenderHand(true);
    }
}
