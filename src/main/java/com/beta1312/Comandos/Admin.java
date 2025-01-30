package com.beta1312.Comandos;

import com.beta1312.Start.Start;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor {

    private Start start;

    public Admin(Start start){
        this.start = start;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("admin")){
                //SETTER CLASE
                if (strings[0].equalsIgnoreCase("setClass")) {
                    Player targetPlayer = start.getServer().getPlayer(strings[1]);
                    if (targetPlayer != null && targetPlayer.isOnline()) {
                        if(strings[2].equalsIgnoreCase("GH")){
                            start.getConfig().set("Players." + targetPlayer.getName() + ".Clase", "GH");
                            targetPlayer.sendMessage("Has sido seleccionado como Guerrero del Hierro");
                        }else if(strings[2].equalsIgnoreCase("HT")){
                            start.getConfig().set("Players." + targetPlayer.getName() + ".Clase", "HT");
                            targetPlayer.sendMessage("Has sido seleccionado como Hechicero de la Tierra");
                        }else if(strings[2].equalsIgnoreCase("HS")) {
                            start.getConfig().set("Players." + targetPlayer.getName() + ".Clase", "HS");
                            targetPlayer.sendMessage("Has sido seleccionado como Hijo del Sol");
                        }else {
                            p.sendMessage("Legion no Registrada");
                        }
                        start.getConfig().set("Players." + targetPlayer.getName() + ".ActionBar", "⚔1:0  ⛉2:0  ⚔3:0  ⛉4:0  ⚔5:0");
                        start.saveConfig();
                    } else {
                        p.sendMessage("Player not found or not online.");
                    }

                }
            }else{
                p.sendMessage("No tienes permisos");
            }
        }
        return false;
    }
}
