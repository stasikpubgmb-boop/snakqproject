package com.snakq.client.setting;

public class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String name, boolean value) {
        super(name, value);
    }

    public void toggle() { setValue(!getValue()); }
}
