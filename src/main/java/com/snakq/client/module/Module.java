package com.snakq.client.module;

import net.minecraft.util.math.MathHelper;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int keybind;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
        this.keybind = -1;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getKeybind() {
        return keybind;
    }

    public void setKeybind(int keybind) {
        this.keybind = keybind;
    }

    public abstract void tick();
}
