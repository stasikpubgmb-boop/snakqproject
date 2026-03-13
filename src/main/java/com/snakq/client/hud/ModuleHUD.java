package com.snakq.client.hud;
import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import java.awt.Color;
public class ModuleHUD {
    public void render(MatrixStack matrices) {
        int x = 10;
        int y = 10;
        for (Module module : ModuleManager.getModules()) {
            if (module.isEnabled()) {
                drawStringWithShadow(matrices, Text.literal(module.getName()), x, y, Color.WHITE.getRGB());
                y += 10;
            }
        }
    }
}
