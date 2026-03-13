package com.snakq.client.module;

public abstract class Module {
    private String moduleName;

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }

    // Removed enum Category to a separate file
    public abstract com.snakq.client.Category getCategory();
}
