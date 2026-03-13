package com.snakq.client.gui;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.buffer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.Vertexbuffer;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class HUD {
    private ModuleManager moduleManager;
    private Minecraft mc;

    public HUD(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
        this.mc = Minecraft.getMinecraft();
    }

    public void draw() {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        for (Module module : moduleManager.getModules()) {
            drawModule(module);
        }

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private void drawModule(Module module) {
        int x = 10;
        int y = 10;

        if (module.getCategory() == Module.Category.COMBAT) {
            x = 10;
            y += 30;
        } else if (module.getCategory() == Module.Category.MOVEMENT) {
            x = 120;
            y = 10;
        } else if (module.getCategory() == Module.Category.MISC) {
            x = 230;
            y = 10;
        }

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos(x, y, 0).color(255, 0, 0, 255).endVertex();
        bufferbuilder.pos(x + 10, y, 0).color(0, 255, 0, 255).endVertex();
        bufferbuilder.pos(x + 10, y + 10, 0).color(0, 0, 255, 255).endVertex();
        bufferbuilder.pos(x, y + 10, 0).color(255, 255, 0, 255).endVertex();
        tessellator.draw();

        mc.fontRendererObj.drawString(module.getName(), x + 15, y + 5, 0xFFFFFF);
    }
}
