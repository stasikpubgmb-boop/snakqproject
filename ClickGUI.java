package com.snakq.client.gui;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;

import java.awt.Color;
import java.util.List;

public class ClickGUI extends Screen {
    private int offsetX;
    private int offsetY;
    private Category currentCategory;

    public ClickGUI() {
        super(Text.literal("ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        List<Module> modules = ModuleManager.getModules();
        int x = 10;
        int y = 10;
        for (Module module : modules) {
            if (module.getCategory() != currentCategory) {
                context.fill(x, y, x + 100, y + 20, Color.decode("#2f2f2f"));
                context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, module.getCategory().name(), x + 10, y + 5, Color.WHITE);
                y += 25;
                currentCategory = module.getCategory();
            }
            context.fill(x, y, x + 100, y + 20, Color.decode("#1f1f1f"));
            context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, module.getName(), x + 10, y + 5, module.isEnabled() ? Color.GREEN : Color.RED);
            if (mouseX > x && mouseX < x + 100 && mouseY > y && mouseY < y + 20) {
                if (mouseButton == 0) {
                    module.toggle();
                } else if (mouseButton == 1) {
                    // Open settings
                } else if (mouseButton == 2) {
                    // Set keybind
                }
            }
            y += 25;
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
