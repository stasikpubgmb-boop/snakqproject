package com.snakq.client.setting;

public class SliderSetting extends Setting<Float> {
    private float min, max;

    public SliderSetting(String name, float value, float min, float max) {
        super(name, value);
        this.min = min;
        this.max = max;
    }

    public float getMin() { return min; }
    public float getMax() { return max; }

    public void setValue(float v) {
        super.setValue(Math.max(min, Math.min(max, v)));
    }
}
