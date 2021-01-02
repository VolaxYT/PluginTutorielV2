package fr.volax.mobs;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;

public class MobsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player)sender;
        Location location = player.getLocation();

        Skeleton skeleton = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        skeleton.setCustomName("§cMob magique");
        skeleton.setCustomNameVisible(true);
        skeleton.setMaxHealth(40);
        skeleton.setHealth(40);
        skeleton.setGlowing(true);
        return false;
    }
}
