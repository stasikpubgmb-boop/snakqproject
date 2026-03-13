package com.snakq.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.MatrixStack;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;

public class ModuleSettingsGUI extends Screen {
    // ...

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        drawBackground(0);
        // ...
    }

    protected void onPressed() {
        if (isMouseButtonDown(0)) {
            // ...
        }
    }

    private boolean isMouseButtonDown(int button) {
        return InputUtil.isMouseButtonDown(client.mouse, button);
    }

    // ...
}
