package fr.volax.plugintutoriel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(player.hasPermission("broadcast.use")){
                if(args.length == 0){
                    player.sendMessage("§aExecution: /broadcast <message>");
                    return false;
                }
                Bukkit.broadcastMessage("§e[§6Broadcast§e] §r" + ChatColor.translateAlternateColorCodes('&', String.join(" ", args)));
                return false;
            }else{
                player.sendMessage("§cVous n'avez pas la permission d'executer cette commande !");
                return false;
            }
        }else{
            sender.sendMessage("Vous devez être un joueur pour executer cette commande !");
        }
        return false;
    }
}
