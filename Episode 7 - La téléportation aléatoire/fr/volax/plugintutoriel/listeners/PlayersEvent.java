package fr.volax.plugintutoriel.listeners;

import fr.volax.plugintutoriel.tools.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class PlayersEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        ItemStack item = new ItemBuilder(Material.MYCELIUM, 1)
                .setName("§eLe super mycelium !")
                .setLore("§6Le super item","il est vraiment cool","","§e§lwow il est trop bien")
                .addEnchant(Enchantment.DAMAGE_ALL, 3)
                .addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 15)
                .addFlag(ItemFlag.HIDE_ENCHANTS)
                .toItemStack();

        player.getInventory().addItem(item);
        player.getInventory().setItem(4, item);

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
