package com.snakq.client.module;
import com.snakq.client.module.impl.combat.KillAura;
import com.snakq.client.module.impl.combat.AutoClicker;
import com.snakq.client.module.impl.combat.Criticals;
import com.snakq.client.module.impl.combat.Reach;
import com.snakq.client.module.impl.combat.Scaffold;
import com.snakq.client.module.impl.movement.NoFall;
import com.snakq.client.module.impl.movement.Sprint;
import com.snakq.client.module.impl.movement.Speed;
import com.snakq.client.module.impl.movement.BunnyHop;
import com.snakq.client.module.impl.visual.Fullbright;
import com.snakq.client.module.impl.visual.ESP;
import com.snakq.client.module.impl.visual.NoFog;
import com.snakq.client.module.impl.misc.Fly;
import com.snakq.client.module.impl.misc.FastPlace;
import java.util.ArrayList; 
import java.util.List;
public class ModuleManager {
    private static List<Module> modules = new ArrayList<>();
    public static void init() { 
        modules.add(new KillAura());
        modules.add(new AutoClicker());
        modules.add(new Criticals());
        modules.add(new Reach());
        modules.add(new Scaffold());
        modules.add(new NoFall());
        modules.add(new Sprint());
        modules.add(new Speed());
        modules.add(new BunnyHop());
        modules.add(new Fullbright());
        modules.add(new ESP());
        modules.add(new NoFog());
        modules.add(new Fly());
        modules.add(new FastPlace());
    }
    public static List<Module> getModules() { 
        return modules; 
    }
}
