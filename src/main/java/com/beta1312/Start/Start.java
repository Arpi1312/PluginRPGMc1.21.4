package com.beta1312.Start;

import com.beta1312.Eventos.Eventos;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Start extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Eventos(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
