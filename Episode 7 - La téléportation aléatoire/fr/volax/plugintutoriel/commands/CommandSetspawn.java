package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetspawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if(player.hasPermission("setspawn")){
                setSpawn(player.getLocation());
                player.sendMessage("§eVous venez de set le spawn à vos coordonnées !");
                return false;
            }else{
                player.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !");
                return false;
            }
        }else{
            ConfigBuilder.getString("messages.test");
            return false;
        }
    }

    private void setSpawn(Location location){
        double X = location.getX();
        double Y = location.getY();
        double Z = location.getZ();

        float yaw = location.getYaw();
        float pitch = location.getPitch();

        String worldName = location.getWorld().getName();

        ConfigBuilder.set("spawn.X", X);
        ConfigBuilder.set("spawn.Y", Y);
        ConfigBuilder.set("spawn.Z", Z);

        ConfigBuilder.set("spawn.yaw", yaw);
        ConfigBuilder.set("spawn.pitch", pitch);

        ConfigBuilder.set("spawn.worldName", worldName);
    }
}
