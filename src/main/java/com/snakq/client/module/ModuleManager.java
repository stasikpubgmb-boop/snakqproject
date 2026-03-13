package com.snakq.client.module;
import com.snakq.client.module.impl.combat.KillAura;
import com.snakq.client.module.impl.movement.Speed;
import java.util.ArrayList; 
import java.util.List;
public class ModuleManager {
    private static List<Module> modules = new ArrayList<>();
    public static void init() { 
        modules.add(new KillAura()); 
        modules.add(new Speed()); 
    }
    public static List<Module> getModules() { 
        return modules; 
    }
}
