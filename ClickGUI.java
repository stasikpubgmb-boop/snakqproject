package com.snakq.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public class ClickGUI extends Screen {

    private ModuleManager moduleManager;

    public ClickGUI(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);

        for (Module module : moduleManager.getModules()) {
            drawModule(module, mouseX, mouseY, matrices);
        }
    }

    private void drawModule(Module module, int mouseX, int mouseY, MatrixStack matrices) {
        int x = 10;
        int y = 10;
        int width = 100;
        int height = 20;

        if (module.getCategory() == Category.COMBAT) {
            x = 10;
            y += 30;
        } else if (module.getCategory() == Category.MOVEMENT) {
            x = 120;
            y = 10;
        } else if (module.getCategory() == Category.MISC) {
            x = 230;
            y = 10;
        }

        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, VertexFormats.POSITION_COLOR);
        if (module.isEnabled()) {
            bufferBuilder.vertex(x, y + height, 0).color(0, 255, 0, 150).next();
            bufferBuilder.vertex(x + width, y + height, 0).color(0, 255, 0, 150).next();
            bufferBuilder.vertex(x + width, y, 0).color(0, 255, 0, 150).next();
            bufferBuilder.vertex(x, y, 0).color(0, 255, 0, 150).next();
        } else {
            bufferBuilder.vertex(x, y + height, 0).color(128, 128, 128, 150).next();
            bufferBuilder.vertex(x + width, y + height, 0).color(128, 128, 128, 150).next();
            bufferBuilder.vertex(x + width, y, 0).color(128, 128, 128, 150).next();
            bufferBuilder.vertex(x, y, 0).color(128, 128, 128, 150).next();
        }
        tessellator.draw();

        textRenderer.drawWithShadow(matrices, module.getName(), x + 5, y + 5, 0xFFFFFF);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
