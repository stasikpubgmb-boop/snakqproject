package com.snakq.client.module.impl.combat;
import com.snakq.client.module.Category;
import com.snakq.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
public class Scaffold extends Module {
    public Scaffold() { super("Scaffold", Category.COMBAT); }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null || mc.world == null) return;
        BlockPos below = mc.player.getBlockPos().down();
        if (!mc.world.getBlockState(below).isAir()) return;
        for (int i = 0; i < 9; i++) {
            if (mc.player.getInventory().getStack(i).getItem() instanceof BlockItem) {
                mc.player.getInventory().selectedSlot = i;
                BlockHitResult hit = new BlockHitResult(
                    Vec3d.ofCenter(below), Direction.UP, below, false);
                mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, hit);
                break;
            }
        }
    }
}
