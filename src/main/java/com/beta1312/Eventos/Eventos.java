package com.beta1312.Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Eventos implements Listener {
    @EventHandler
    public void prueba(PlayerMoveEvent e){
        e.getPlayer().sendMessage("Hola!");
    }
}
