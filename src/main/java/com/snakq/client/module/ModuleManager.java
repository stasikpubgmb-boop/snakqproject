package com.snakq.client.module;

import com.snakq.client.module.impl.combat.Criticals;
import com.snakq.client.module.impl.combat.KillAura;
import com.snakq.client.module.impl.combat.Reach;
import com.snakq.client.module.impl.combat.AutoClicker;
import com.snakq.client.module.impl.combat.Scaffold;
import com.snakq.client.module.impl.movement.Speed;
import com.snakq.client.module.impl.movement.Sprint;
import com.snakq.client.module.impl.movement.BunnyHop;
import com.snakq.client.module.impl.movement.NoFall;
import com.snakq.client.module.impl.movement.Fly;
import com.snakq.client.module.impl.visual.ESP;
import com.snakq.client.module.impl.visual.Fullbright;
import com.snakq.client.module.impl.visual.Tracers;
import com.snakq.client.module.impl.visual.NoFog;
import com.snakq.client.module.impl.misc.FastPlace;

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
        modules.add(new Speed());
        modules.add(new Sprint());
        modules.add(new BunnyHop());
        modules.add(new NoFall());
        modules.add(new Fly());
        modules.add(new ESP());
        modules.add(new Fullbright());
        modules.add(new Tracers());
        modules.add(new NoFog());
        modules.add(new FastPlace());

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
