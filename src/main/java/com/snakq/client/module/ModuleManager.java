package com.snakq.client.module;
import com.snakq.client.module.impl.combat.KillAura;
import com.snakq.client.module.impl.combat.AutoClicker;
import com.snakq.client.module.impl.combat.Criticals;
import com.snakq.client.module.impl.movement.NoFall;
import com.snakq.client.module.impl.movement.Sprint;
import com.snakq.client.module.impl.movement.Speed;
import com.snakq.client.module.impl.visual.Fullbright;
import java.util.ArrayList; 
import java.util.List;
public class ModuleManager {
    private static List<Module> modules = new ArrayList<>();
    public static void init() { 
        modules.add(new KillAura());
        modules.add(new Speed());
        modules.add(new AutoClicker());
        modules.add(new Criticals());
        modules.add(new NoFall());
        modules.add(new Sprint());
        modules.add(new Fullbright());
    }
    public static List<Module> getModules() { 
        return modules; 
    }
}
