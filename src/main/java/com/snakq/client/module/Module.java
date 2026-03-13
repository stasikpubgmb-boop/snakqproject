package com.snakq.client.module;
public abstract class Module {
    private String name; 
    private Category category; 
    private boolean enabled;
    public Module(String name, Category category) { 
        this.name=name; 
        this.category=category; 
    }
    public void toggle() { 
        enabled=!enabled; 
        if(enabled) onEnable(); 
        else onDisable(); 
    }
    public boolean isEnabled() { 
        return enabled; 
    }
    public String getName() { 
        return name; 
    }
    public Category getCategory() { 
        return category; 
    }
    public void onEnable() {} 
    public void onDisable() {} 
    public void onTick() {}
}
