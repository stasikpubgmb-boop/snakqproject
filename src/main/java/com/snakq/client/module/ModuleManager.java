package com.snakq.client.module;

import com.snakq.client.module.impl.combat.Criticals;
import com.snakq.client.module.impl.combat.KillAura;
import com.snakq.client.module.impl.combat.Reach;
import com.snakq.client.module.impl.combat.AutoClicker;
import com.snakq.client.module.impl.combat.Scaffold;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private List<Module> modules = new ArrayList<>();

    public void init() {
        modules.add(new KillAura());
        modules.add(new AutoClicker());
        modules.add(new Reach());
        modules.add(new Criticals());
        modules.add(new Scaffold());

        for (Module module : modules) {
            module.setEnabled(true);
        }
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}

