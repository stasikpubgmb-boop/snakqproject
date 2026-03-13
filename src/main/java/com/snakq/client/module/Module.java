package com.snakq.client.module;

public enum Category {
    COMBAT,
    MOVEMENT,
    MISC
}

public interface Module {
    String getName();
    Category getCategory();
    boolean isEnabled();
    void setEnabled(boolean enabled);
}
