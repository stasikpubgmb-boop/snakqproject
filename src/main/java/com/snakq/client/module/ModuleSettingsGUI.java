package com.snakq.client.module;

import com.snakq.client.module.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;

public class ModuleSettingsGUI extends GuiScreen {

    private Module module;

    public ModuleSettingsGUI(Module module) {
        this.module = module;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_alpha);

        drawBackground(0);

        for (int i = 0; i < 10; i++) {
            drawSlider(mouseX, mouseY, i * 20);
        }

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private void drawSlider(int mouseX, int mouseY, int y) {
        int x = 10;
        int width = 100;
        int height = 20;

        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

        if (isHovered) {
            if (isMouseButtonDown(0)) {
                // update slider value
            }
        }

        Gui.drawRect(x, y, x + width, y + height, new Color(128, 128, 128, 150).getRGB());
        Gui.drawRect(x, y, x + (width * 50 / 100), y + height, new Color(0, 255, 0, 150).getRGB());
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
    }

    @Override
    public void handleKeyboardInput() throws IOException {
        super.handleKeyboardInput();
    }
}
