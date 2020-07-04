package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetCoordonnees implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            Location location = player.getLocation();
            double X = location.getX();
            double Y = location.getY();
            double Z = location.getZ();

            String worldName = location.getWorld().getName();

            float yaw = location.getYaw();
            float pitch = location.getPitch();

            for(int i = 0; i <= 100; i++){
                if(ConfigBuilder.getInt("coordonnees.coordonnees_" + i + ".Y") == 0){
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".X", X);
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".Y", Y);
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".Z", Z);
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".yaw", yaw);
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".pitch", pitch);
                    ConfigBuilder.set("coordonnees.coordonnees_" + i + ".worldName", worldName);

                    player.sendMessage("§aVous venez d'enregister vos coordonnées dans la base de coordonnées !");
                }
            }
        }else{
            sender.sendMessage(ConfigBuilder.getString("messages.test"));
            return false;
        }
        return false;
    }
}
