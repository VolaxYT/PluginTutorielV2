package fr.volax.tutoriel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TutorielCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if(TutorielMain.particles.contains(player))
            TutorielMain.particles.remove(player);
        else
            TutorielMain.particles.add(player);
        return false;
    }
}
