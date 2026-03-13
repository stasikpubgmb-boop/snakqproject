package com.snakq.client.gui;

import net.minecraft.client.render.*;
import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;

public class HUD {
    private ModuleManager moduleManager;

    public HUD(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    public void render(MatrixStack matrices) {
        // ...
    }
}
