package com.snakq.client.gui;

import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import java.util.List;

public class ClickGUI extends Screen {

    public ClickGUI() {
        super(Text.literal("ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int x = 10;
        int y = 10;
        List<Module> modules = ModuleManager.getModules();
        for (Module module : modules) {
            int color = module.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
            context.fill(x, y, x + 100, y + 12, 0xAA000000);
            context.drawTextWithShadow(textRenderer, module.getName(), x + 2, y + 2, color);
            y += 14;
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int x = 10;
        int y = 10;
        for (Module module : ModuleManager.getModules()) {
            if (mouseX >= x && mouseX <= x + 100 && mouseY >= y && mouseY <= y + 12) {
                module.toggle();
                return true;
            }
            y += 14;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
