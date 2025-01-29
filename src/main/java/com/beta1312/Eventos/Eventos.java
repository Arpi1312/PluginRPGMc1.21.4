package com.beta1312.Eventos;

import com.beta1312.Start.Start;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Eventos implements Listener {
    private Start start;

    public Eventos(Start start) {
        this.start = start;
    }

    @EventHandler
    public void prueba(PlayerJoinEvent e){
        start.getConfigManager().savePlayerData(e.getPlayer(), "Nombre" , e.getPlayer().getName());
    }
}
