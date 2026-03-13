package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import com.snakq.client.setting.SliderSetting;
public class Reach extends Module {
    public SliderSetting range = new SliderSetting("Range", 4.5f, 3.0f, 6.0f);
    public Reach() { super("Reach", Category.COMBAT); addSetting(range); }
    @Override public void onTick() {}
}
