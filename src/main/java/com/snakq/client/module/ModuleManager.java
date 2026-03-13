package com.snakq.client.module;

import com.snakq.client.module.impl.combat.*;
import com.snakq.client.module.impl.movement.*;
import com.snakq.client.module.impl.visual.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    private static List<Module> modules = new ArrayList<>();

    public static void init() {
        modules.add(new KillAura());
        modules.add(new AutoClicker());
        modules.add(new Criticals());
        modules.add(new Reach());
        modules.add(new Speed());
        modules.add(new Sprint());
        modules.add(new BunnyHop());
        modules.add(new NoFall());
        modules.add(new Fly());
        modules.add(new Fullbright());
        modules.add(new ESP());
        modules.add(new NoFog());
    }

    public static List<Module> getModules() { return modules; }

    public static List<Module> getByCategory(Category cat) {
        return modules.stream()
                .filter(m -> m.getCategory() == cat)
                .collect(Collectors.toList());
    }

    public static void onTick() {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }

    public static void onKey(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) m.toggle();
        }
    }
}
