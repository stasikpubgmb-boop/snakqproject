package com.snakq/client/module/impl/combat;

import com.snakq.client.module.Module;
import com.snakq.client.module.Category;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Scaffold extends Module {

    public Scaffold() {
        super("Scaffold", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        // Code to run when the module is enabled
    }

    @Override
    public void onDisable() {
        // Code to run when the module is disabled
    }

    public void update() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.player == null || client.world == null) {
            return;
        }

        ClientPlayerEntity player = client.player;
        BlockPos playerPos = player.getBlockPos();
        World world = client.world;

        for (Direction direction : Direction.values()) {
            BlockPos blockPos = playerPos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);

            if (blockState.getBlock() == Blocks.AIR) {
                placeBlockAtPos(player, world, blockPos);
            }
        }
    }

    private void placeBlockAtPos(ClientPlayerEntity player, World world, BlockPos pos) {
        for (int i = 0; i < player.inventory.size(); i++) {
            ItemStack itemStack = player.inventory.getStack(i);
            if (itemStack.getItem() instanceof net.minecraft.item.BlockItem) {
                player.inventory.selectedSlot = i;
                player.networkHandler.sendPacket(new net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket(net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, pos, Direction.DOWN));
                player.swingHand(Hand.MAIN_HAND);
                player.networkHandler.sendPacket(new net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket(net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action.STOP_DESTROY_BLOCK, pos, Direction.DOWN));
                return;
            }
        }
    }
}

