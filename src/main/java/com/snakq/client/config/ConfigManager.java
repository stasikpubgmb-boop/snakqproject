package com.snakq.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.snakq.client.module.Module;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private Map<String, Module> moduleConfig = new HashMap<>();

    public void load() {
        try (FileReader reader = new FileReader("config.json")) {
            Gson gson = new Gson();
            Module[] modules = gson.fromJson(reader, Module[].class);

            for (Module module : modules) {
                moduleConfig.put(module.getName(), module);
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            // handle exception
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter("config.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Module[] modules = moduleConfig.values().toArray(new Module[0]);
            gson.toJson(modules, writer);
        } catch (IOException e) {
            // handle exception
        }
    }
}
