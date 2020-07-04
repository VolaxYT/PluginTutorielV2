package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.gui.MenuTutoriel;
import fr.volax.plugintutoriel.managers.Managers;
import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandTest implements CommandExecutor, TabCompleter {
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
    List<String> arguments = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(arguments.isEmpty()){
            arguments.add("test");
            arguments.add("volax");
            arguments.add("youtube");
            arguments.add("teste");
        }
        List<String> resultat = new ArrayList<>();

        if(args.length == 1){
            for(String str : arguments){
                if(str.toLowerCase().startsWith(args[0].toLowerCase())){
                    resultat.add(str);
                }
            }
            return resultat;
        }

        return null;
    }
}
