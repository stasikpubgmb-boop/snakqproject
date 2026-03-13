package com.snakq.client.gui;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import java.awt.Color;
public class ClickGUI extends Screen {
    private int dragX;
    private int dragY;
    private boolean isDragging;
    public ClickGUI() {
        super(Text.literal(""));
    }
    @Override
    protected void init() {
        super.init();
        for (Module module : ModuleManager.getModules()) {
            int x = 10;
            int y = 10;
            ButtonWidget button = new ButtonWidget(x, y, 100, 20, Text.literal(module.getName()), press -> {
                module.toggle();
            });
            this.addDrawableChild(button);
        }
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        fill(matrices, 0, 0, width, height, new Color(0, 0, 0, 128).getRGB());
        for (Module module : ModuleManager.getModules()) {
            int x = 10;
            int y = 10;
            if (module.getCategory() == Category.COMBAT) {
                x = 10;
                y += 20;
            } else if (module.getCategory() == Category.MOVEMENT) {
                x = 120;
                y += 20;
            } else if (module.getCategory() == Category.VISUAL) {
                x = 230;
                y += 20;
            } else if (module.getCategory() == Category.MISC) {
                x = 340;
                y += 20;
            }
            drawStringWithShadow(matrices, textRenderer, module.getName(), x, y, Color.WHITE.getRGB());
            if (module.isEnabled()) {
                drawRect(matrices, x + 100, y, 10, 10, Color.GREEN.getRGB());
            } else {
                drawRect(matrices, x + 100, y, 10, 10, Color.RED.getRGB());
            }
        }
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Module module : ModuleManager.getModules()) {
            int x = 10;
            int y = 10;
            if (module.getCategory() == Category.COMBAT) {
                x = 10;
                y += 20;
            } else if (module.getCategory() == Category.MOVEMENT) {
                x = 120;
                y += 20;
            } else if (module.getCategory() == Category.VISUAL) {
                x = 230;
                y += 20;
            } else if (module.getCategory() == Category.MISC) {
                x = 340;
                y += 20;
            }
            if (button == 0 && mouseX > x && mouseX < x + 100 && mouseY > y && mouseY < y + 20) {
                module.toggle();
            } else if (button == 1 && mouseX > x && mouseX < x + 100 && mouseY > y && mouseY < y + 20) {
                // Show settings for the module
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
