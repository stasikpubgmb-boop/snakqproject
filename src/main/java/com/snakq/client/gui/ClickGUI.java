package com.snakq.client.gui;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.List;

public class ClickGUI extends Screen {
    private int offset;

    public ClickGUI() {
        super(Text.of("ClickGUI"));
    }

    @Override
    public void init() {
        offset = 0;
        List<Module> modules = ModuleManager.getModules();
        for (Module module : modules) {
            // Add module buttons here
            addDrawableChild(new ButtonWidget(10, 10 + offset, 100, 20, Text.of(module.getName()), (button) -> {
                // Toggle module
                module.setEnabled(!module.isEnabled());
            }));
            offset += 25;
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        List<Module> modules = ModuleManager.getModules();
        int y = 10;
        for (Module module : modules) {
            // Draw module text
            textRenderer.draw(matrices, module.getName(), 10, y, module.isEnabled() ? 0xFF00FF : 0xFF0000);
            y += 20;
        }
        super.render(matrices, mouseX, mouseY, delta);
    }
}
