package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandCoordonnees implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            int randomNumber = new Random().nextInt(maxCoordonnees() + 1);
            double X = ConfigBuilder.getDouble("coordonnees.coordonnees_" + randomNumber + ".X");
            double Y = ConfigBuilder.getDouble("coordonnees.coordonnees_" + randomNumber + ".Y");
            double Z = ConfigBuilder.getDouble("coordonnees.coordonnees_" + randomNumber + ".Z");
            float yaw = ConfigBuilder.getInt("coordonnees.coordonnees_" + randomNumber + ".yaw");
            float pitch = ConfigBuilder.getInt("coordonnees.coordonnees_" + randomNumber + ".pitch");

            World world = Bukkit.getWorld(ConfigBuilder.getString("coordonnees.coordonnees_" + randomNumber + ".worldName"));
            Location teleportLocation = new Location(world, X,Y,Z,yaw,pitch);

            player.teleport(teleportLocation);
            player.sendMessage("§aTéléportation aléatoire !");
            return false;
        }else{
            sender.sendMessage(ConfigBuilder.getString("messages.test"));
            return false;
        }
    }

    private int maxCoordonnees(){
        for(int i = 0; i < 100; i++){
            if(ConfigBuilder.getInt("coordonnees.coordonnees_" + 0 + ".Y") == 0){
                return i - 1;
            }
        }
        return 0;
    }
}
