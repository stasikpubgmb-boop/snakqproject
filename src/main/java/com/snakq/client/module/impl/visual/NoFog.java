package com.snakq.client.module.impl.visual;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;

public class NoFog extends Module {
    public NoFog() {
        super("NoFog", Category.RENDER);
    }

    @Override
    public void onEnable() {
        // Add no fog modification code here
    }

    @Override
    public void onDisable() {
        // Add no fog reset code here
    }
}

