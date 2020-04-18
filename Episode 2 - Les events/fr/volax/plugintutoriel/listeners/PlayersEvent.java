package fr.volax.plugintutoriel.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayersEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(!player.hasPlayedBefore()){
            event.setJoinMessage("§eLe joueur " + player.getName() + " vient de rejoindre ! C'est ça première connexion bienvenue !");
        }else{
            event.setJoinMessage("§eLe joueur " + player.getName() + " vient de rejoindre !");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage("§eLe joueur " + player.getName() + " vient de quitter ! Au revoir !");
    }
}
