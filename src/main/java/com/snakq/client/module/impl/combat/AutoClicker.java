package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
public class AutoClicker extends Module {
    private double cps = 12.5; // clicks per second
    private long lastClick = 0;
    public AutoClicker() { 
        super("AutoClicker", Category.COMBAT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        if(mc.options.attackKey.isPressed()) {
            long now = System.currentTimeMillis();
            if(now - lastClick >= (long) (1000 / cps)) {
                mc.player.swingHand(Hand.MAIN_HAND);
                lastClick = now;
            }
        }
    }
}
