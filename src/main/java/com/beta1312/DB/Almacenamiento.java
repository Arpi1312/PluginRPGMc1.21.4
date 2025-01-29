package com.beta1312.DB;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Almacenamiento {

    private final FileConfiguration config;

    public Almacenamiento(FileConfiguration config) {
        this.config = config;
    }

    // Guardar datos del jugador
    public void savePlayerData(Player player, String key, Object value) {
        String path = "players." + player.getUniqueId() + "." + key; // Ruta en el config.yml
        config.set(path, value); // Escribe el valor en la configuración
    }

    // Obtener datos del jugador
    public Object getPlayerData(Player player, String key) {
        String path = "players." + player.getUniqueId() + "." + key; // Ruta en el config.yml
        return config.get(path); // Retorna el valor desde el archivo
    }

    // Guardar los datos en el archivo
    public void saveConfigFile() {
        // Aquí guardamos realmente los cambios al config.yml
        try {
            if (config != null) {
                config.save("plugins/NombreDelPlugin/config.yml"); // Ruta absoluta
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}