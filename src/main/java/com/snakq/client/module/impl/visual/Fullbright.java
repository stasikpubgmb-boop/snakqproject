package com.snakq.client.module.impl.visual;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", Category.RENDER);
    }

    @Override
    public void onEnable() {
        // Add fullbright modification code here with gamma 10000
    }

    @Override
    public void onDisable() {
        // Add fullbright reset code here
    }
}

