package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.gui.MenuTutoriel;
import fr.volax.plugintutoriel.managers.Managers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Managers.getManagers().getGuiManager().open(player, MenuTutoriel.class);
        }else{
            sender.sendMessage("Vous devez être un joueur pour executer cette commande !");
        }
        return false;
    }
}
