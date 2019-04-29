package com.gmail.andrewandy.randomtp;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class RandomTP extends JavaPlugin {

    private static RandomTP instance;


    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        instance = null;
        // Plugin shutdown logic
    }

    public static RandomTP getInstance() {
        return instance;
    }
}
