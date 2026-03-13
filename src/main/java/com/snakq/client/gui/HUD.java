package com.snakq.client.gui;

import net.minecraft.client.render.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack.Entry;
import com.snakq.client.module.Module;
import com.snakq.client.module.ModuleManager;

public class HUD {
    private ModuleManager moduleManager;

    public HUD(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    public void render(MatrixStack matrices) {
        VertexConsumerProvider.Immediate buffer = VertexConsumerProvider.immediate(Tessellator.getInstance().getBuffer());
        matrices.peek().getMatrix(); // You had an error here, it seems you wanted to get the matrix, not pass it to a function
        buffer.end();
    }
}
