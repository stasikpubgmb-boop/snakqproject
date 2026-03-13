package com.snakq.client.module.impl.movement;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;

public class Speed extends Module {
    public Speed() {
        super("Speed", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        // Add speed modification code here
    }

    @Override
    public void onDisable() {
        // Add speed reset code here
    }
}

