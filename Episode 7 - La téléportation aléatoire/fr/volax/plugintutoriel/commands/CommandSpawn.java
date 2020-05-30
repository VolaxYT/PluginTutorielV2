package fr.volax.plugintutoriel.commands;

import fr.volax.plugintutoriel.tools.ConfigBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if(player.hasPermission("spawn")){
                spawn(player);
                player.sendMessage("§eVous venez de vous téléportez au spawn !");
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

    private void spawn(Player player){
        double X = ConfigBuilder.getDouble("spawn.X");
        double Y = ConfigBuilder.getDouble("spawn.Y");
        double Z = ConfigBuilder.getDouble("spawn.Z");

        float yaw = ConfigBuilder.getInt("spawn.yaw");
        float pitch = ConfigBuilder.getInt("spawn.pitch");

        String worldName = ConfigBuilder.getString("spawn.worldName");

        Location location = new Location(Bukkit.getWorld(worldName), X,Y,Z,yaw,pitch);
        player.teleport(location);
    }
}
