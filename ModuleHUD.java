package com.snakq.client.hud;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ModuleHUD implements HudRenderCallback {
    private float hue = 0;

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = MinecraftClient.getInstance().width - 10;
        int y = 10;
        for (Module module : ModuleManager.getModules()) {
            if (module.isEnabled()) {
                int color = Color.HSBtoRGB(hue, 1f, 1f);
                drawContext.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, module.getName(), x, y, color);
                y += 10;
                hue = (hue + 0.01f) % 1;
            }
        }
    }
}
