package fr.volax.tutoriel;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class TutorielMain extends JavaPlugin implements Listener {
    public static ArrayList<Player> particles = new ArrayList<>();

    @Override
    public void onEnable() {
        this.getCommand("particles").setExecutor(new TutorielCommand());
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(particles.contains(player))
            player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
    }
}