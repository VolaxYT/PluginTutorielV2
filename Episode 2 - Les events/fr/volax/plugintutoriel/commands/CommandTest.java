package fr.volax.plugintutoriel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage("§aBravo vous avez réussi le test !");
        }else{
            sender.sendMessage("Vous devez être un joueur pour executer cette commande !");
        }
        return false;
    }
}
