package com.snakq.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.snakq.client.module.ModuleManager;
import com.snakq.client.gui.ClickGUI;
import com.snakq.client.module.Module;

public class SnakqClient implements ClientModInitializer {

    public static KeyBinding openGui;

    @Override
    public void onInitializeClient() {
        ModuleManager.init();

        openGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Open ClickGUI",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "SnakqClient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (Module module : ModuleManager.getModules()) {
                module.onTick();
            }
            while (openGui.wasPressed()) {
                client.setScreen(new ClickGUI());
            }
        });
    }
}
