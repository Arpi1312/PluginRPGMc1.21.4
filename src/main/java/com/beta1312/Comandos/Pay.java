package com.beta1312.Comandos;

import com.beta1312.Start.Start;
import org.bukkit.command.CommandExecutor;

public class Pay implements CommandExecutor {

    private Start start;

    public Pay(Start start) {
        this.start = start;
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
            org.bukkit.entity.Player sender = (org.bukkit.entity.Player) commandSender;

            if (strings.length == 2) {
                String targetName = strings[0];
                int amount;
                try {
                    amount = Integer.parseInt(strings[1]);
                } catch (NumberFormatException e) {
                    sender.sendMessage("El monto debe ser un número válido.");
                    return true;
                }

                if (amount <= 0) {
                    sender.sendMessage("El monto debe ser mayor que 0.");
                    return true;
                }

                org.bukkit.entity.Player receiver = sender.getServer().getPlayer(targetName);

                if (receiver == null || !receiver.isOnline()) {
                    sender.sendMessage("El jugador " + targetName + " no se encuentra en línea.");
                    return true;
                }

                if(receiver.equals(sender)){
                    sender.sendMessage("No se pueden realizar transacciones con el mismo jugador");
                    return true;
                }

                String senderPath = "Players." + sender.getName() + ".Drakens";
                String receiverPath = "Players." + receiver.getName() + ".Drakens";

                int senderBalance = start.getConfig().getInt(senderPath);
                if (senderBalance < amount) {
                    sender.sendMessage("No tienes suficientes Drakens para completar la transacción.");
                    return true;
                }

                int receiverBalance = start.getConfig().getInt(receiverPath);
                start.getConfig().set(senderPath, senderBalance - amount);
                start.getConfig().set(receiverPath, receiverBalance + amount);
                start.saveConfig();

                sender.sendMessage("Has enviado " + amount + " Drakens a " + receiver.getName() + ".");
                receiver.sendMessage("Has recibido " + amount + " Drakens de " + sender.getName() + ".");
                return true;
            } else {
                sender.sendMessage("Uso: /pay <Jugador> <Cantidad>");
            }

        return true;
    }
}
