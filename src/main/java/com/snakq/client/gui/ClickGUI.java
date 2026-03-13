package com.snakq.client.gui;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import com.snakq.client.module.impl.ModuleImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;

public class ClickGUI extends GuiScreen {

    private ModuleManager moduleManager;
    private Minecraft mc;

    public ClickGUI(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
        this.mc = Minecraft.getMinecraft();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        for (Module module : moduleManager.getModules()) {
            drawModule(module, mouseX, mouseY);
        }

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private void drawModule(Module module, int mouseX, int mouseY) {
        int x = 10;
        int y = 10;
        int width = 100;
        int height = 20;

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

        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

        if (isHovered) {
            if (mc.gameSettings.rightShiftKeyBind.isPressed()) {
                module.setEnabled(!module.isEnabled());
            }

            if (mc.gameSettings.rightClickKeyBind.isPressed()) {
                mc.displayGuiScreen(new ModuleSettingsGUI(module));
            }

            if (mc.gameSettings.middleClickKeyBind.isPressed()) {
                // set keybind
            }
        }

        if (module.isEnabled()) {
            Gui.drawRect(x, y, x + width, y + height, new Color(0, 255, 0, 150).getRGB());
        } else {
            Gui.drawRect(x, y, x + width, y + height, new Color(128, 128, 128, 150).getRGB());
        }

        fontRendererObj.drawString(module.getName(), x + 5, y + 5, 0xFFFFFF);
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
