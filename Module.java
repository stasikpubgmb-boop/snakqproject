package com.snakq.client.module;

import com.snakq.client.Category;

public abstract class Module {
    public abstract Category getCategory();

    public abstract boolean isEnabled();

    // ...
}
