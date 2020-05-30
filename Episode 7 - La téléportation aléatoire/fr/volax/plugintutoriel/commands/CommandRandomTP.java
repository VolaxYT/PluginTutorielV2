package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandRandomTP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            double X = new Random().nextInt(1000);
            double Z = new Random().nextInt(1000);
            World world = player.getWorld();
            Location location;
            location = new Location(world, X,  100, Z);
            double Y = getSafeY(location);
            location = new Location(world, X, Y, Z);

            player.teleport(location);
            player.sendMessage("§aTéléportation aléatoire !");
            return false;
        }else{
            sender.sendMessage(ConfigBuilder.getString("messages.test"));
            return false;
        }
    }

    private double getSafeY(Location location) {
        location.setY(location.getWorld().getHighestBlockYAt(location));
        return location.getY();
    }
}
