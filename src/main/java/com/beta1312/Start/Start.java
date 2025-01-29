package com.beta1312.Start;

import com.beta1312.DB.Almacenamiento;
import com.beta1312.Eventos.Eventos;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Start extends JavaPlugin {

    private Almacenamiento db;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        db = new Almacenamiento(getConfig());
        Bukkit.getPluginManager().registerEvents(new Eventos(this), this);
    }

    @Override
    public void onDisable() {
        // Ejemplo: Guardar los cambios al archivo
        if (db != null) {
            db.saveConfigFile(); // Asegúrate de guardar los datos
        }
    }

    public Almacenamiento getConfigManager() {
        return db;
    }

}
