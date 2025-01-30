package com.beta1312.Eventos;

import com.beta1312.Start.Start;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Eventos implements Listener {
    private final Start start;

    public Eventos(Start start) {
        this.start = start;
    }

    @EventHandler
    public void valoresIniciales(PlayerJoinEvent e) {
        String playerName = e.getPlayer().getName();
        if (!start.getConfig().contains("Players." + playerName)) {
            e.getPlayer().sendMessage("Bienvenido nuevamente al servidor!");
            e.getPlayer().sendMessage("No olvides leer nuestras reglas en Discord");
            e.getPlayer().sendMessage("Diviertete!");
            start.getConfig().set("Players." + playerName + ".Clase", "Mortal");
            start.getConfig().set("Players." + playerName + ".At1", 0);
            start.getConfig().set("Players." + playerName + ".At2", 0);
            start.getConfig().set("Players." + playerName + ".At3", 0);
            start.getConfig().set("Players." + playerName + ".At4", 0);
            start.getConfig().set("Players." + playerName + ".At5", 0);
            start.getConfig().set("Players." + playerName + ".Drakens", 0);
            start.getConfig().set("Players." + playerName + ".Exp", 0);
            start.getConfig().set("Players." + playerName + ".ActionBar", "Solo eres un patetico mortal");
            start.saveConfig();
        } else {
            e.getPlayer().sendMessage("Hola de nuevo " + playerName + "!");
        }



        new BukkitRunnable() {

            @Override
            public void run() {
                // Verifica si el jugador está conectado
                if (!e.getPlayer().isOnline()) {
                    cancel();
                    return;
                }



                String p = start.getConfig().getString("Players." + e.getPlayer().getName() + ".ActionBar");
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(p));

            }
        }.runTaskTimer(start, 0L, 100L);

    }
}