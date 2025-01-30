package com.beta1312.Comandos;

import com.beta1312.Start.Start;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class Up implements CommandExecutor {

    private Start start;
    public Up(Start start){
    }
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            String playerName = commandSender.getName();
            if(strings.length == 1){
                int exp = start.getConfig().getInt("Players."+commandSender.getName()+".Exp");
                int a1,a2,a3,a4,a5;
                a1 = start.getConfig().getInt("Players."+commandSender.getName()+".At1");
                a2 = start.getConfig().getInt("Players."+commandSender.getName()+".At2");
                a3 = start.getConfig().getInt("Players."+commandSender.getName()+".At3");
                a4 = start.getConfig().getInt("Players."+commandSender.getName()+".At4");
                a5 = start.getConfig().getInt("Players."+commandSender.getName()+".At5");
                switch (strings[0]){
                    case "1":
                        if (exp>=100) {
                            if (!(a1 == 5)) {
                                a1++;
                                start.getConfig().set("Players." + commandSender.getName() + ".At1",a1);
                                start.saveConfig();
                                commandSender.sendMessage("Has subido 1 punto a tu ataque 1");
                            } else {
                                commandSender.sendMessage("No se puede subir mas tu ataque 1");
                            }
                        }else {
                            commandSender.sendMessage("No tienes suficiente experiencia");
                        }
                        break;
                    case "2":
                        if (exp>=100) {
                            if (!(a2 == 5)) {
                                a2++;
                                start.getConfig().set("Players." + commandSender.getName() + ".At2", a2);
                                start.saveConfig();
                                commandSender.sendMessage("Has subido 1 punto a tu defensa 2");
                            } else {
                                commandSender.sendMessage("No se puede subir mas tu defensa 2");
                            }
                        }else {
                            commandSender.sendMessage("No tienes suficiente experiencia");
                        }
                        break;
                    case "3":
                        if (exp>=100) {
                            if (!(a3 == 5)) {
                                a3++;
                                start.getConfig().set("Players." + commandSender.getName() + ".At3", a3);
                                start.saveConfig();
                                commandSender.sendMessage("Has subido 1 punto a tu ataque 3");
                            } else {
                                commandSender.sendMessage("No se puede subir mas tu ataque 3");
                            }
                        }else {
                            commandSender.sendMessage("No tienes suficiente experiencia");
                        }
                        break;
                    case "4":
                        if (exp>=100) {
                            if (!(a4 == 5)) {
                                a4++;
                                start.getConfig().set("Players." + commandSender.getName() + ".At4", a4);
                                start.saveConfig();
                                commandSender.sendMessage("Has subido 1 punto a tu defensa 4");
                            } else {
                                commandSender.sendMessage("No se puede subir mas tu defensa 4");
                            }
                        }else {
                            commandSender.sendMessage("No tienes sufiente experiencia");
                        }
                        break;
                    case "5":
                        if (exp>=100) {
                            if (!(a5 == 5)) {
                                a5++;
                                start.getConfig().set("Players." + commandSender.getName() + ".At5", a5);
                                start.saveConfig();
                                commandSender.sendMessage("Has subido 1 punto a tu ataque 5");
                            } else {
                                commandSender.sendMessage("No se puede subir mas tu ataque 5");
                            }
                        }else {
                            commandSender.sendMessage("No tienes suficiente experiencia");
                        }
                        break;
                    default:
                        commandSender.sendMessage("Error! No existe ese poder");
                        break;
                }
                start.getConfig().set("Players."+commandSender.getName()+".ActionBar", "⚔1:"+String.valueOf(a1)+"  ⛉2:"+String.valueOf(a2)+"  ⚔3:"+String.valueOf(a3)+"  ⛉4:"+String.valueOf(a4)+"  ⚔5:"+String.valueOf(a5));
                start.saveConfig();
            }
        }
        return false;
    }
}
