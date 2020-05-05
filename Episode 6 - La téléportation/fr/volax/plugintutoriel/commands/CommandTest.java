package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.gui.MenuTutoriel;
import fr.volax.plugintutoriel.managers.Managers;
import fr.volax.plugintutoriel.tools.ConfigBuilder;
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
            player.sendMessage(ConfigBuilder.getString("messages.test-2") + ConfigBuilder.getInt("messages.chiffre"));
        }else{
            sender.sendMessage(ConfigBuilder.getString("messages.test"));
        }
        return false;
    }
}
