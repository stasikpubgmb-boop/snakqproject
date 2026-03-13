package com.snakq.client.module.impl.movement;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;

public class Fly extends Module {
    public Fly() {
        super("Fly", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        // Add fly modification code here
    }

    @Override
    public void onDisable() {
        // Add fly reset code here
    }
}

