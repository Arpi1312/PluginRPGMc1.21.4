package com.beta1312.Start;

import com.beta1312.Comandos.Admin;
import com.beta1312.Comandos.Pay;
import com.beta1312.Comandos.Up;
import com.beta1312.Eventos.Eventos;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Start extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Eventos(this), this);
        getCommand("admin").setExecutor(new Admin(this));
        getCommand("up").setExecutor(new Up(this));
        getCommand("pay").setExecutor(new Pay(this));
    }

    @Override
    public void onDisable() {

    }

}
