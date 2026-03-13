package com.snakq.client.module.impl.visual;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class ESP extends Module {
    public ESP() { super("ESP", Category.VISUAL); }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;
        // ESP rendering via mixin would be ideal, basic impl here
    }
}
