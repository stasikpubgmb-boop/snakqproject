package com.snakq.client.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private List<Module> modules = new ArrayList<>();

    public void registerModule(Module module) {
        modules.add(module);
    }

    public void init() {
        for (Module module : modules) {
            module.init();
        }
    }

    public List<Module> getModules() {
        return modules;
    }
}
