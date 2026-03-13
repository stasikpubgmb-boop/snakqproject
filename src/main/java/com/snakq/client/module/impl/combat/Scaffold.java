package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category; 
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
public class Scaffold extends Module {
    public Scaffold() { 
        super("Scaffold", Category.COMBAT); 
    }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player==null||mc.world==null) return;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = mc.player.inventory.getStack(i);
            if (!stack.isEmpty() && stack.getItem() instanceof net.minecraft.item.BlockItem) {
                // Find the block below the player
                net.minecraft.util.math.BlockPos pos = mc.player.getBlockPos().down();
                if (mc.world.getBlockState(pos).isAir()) {
                    // Place the block
                    mc.player.swingHand(Hand.MAIN_HAND);
                    mc.interactionManager.useItem(mc.player, Hand.MAIN_HAND);
                }
            }
        }
    }
}
