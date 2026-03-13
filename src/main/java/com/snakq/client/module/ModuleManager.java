package com.snakq.client.module;

import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static List<Module> modules;

    public static void init() {
        modules = new ArrayList<>();
        // Register modules here
        modules.add(new KillAura());
        modules.add(new Speed());
    }

    public static List<Module> getModules() {
        return modules;
    }
}
