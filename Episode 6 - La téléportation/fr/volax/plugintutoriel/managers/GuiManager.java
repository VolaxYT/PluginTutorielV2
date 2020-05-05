package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.tools.GuiBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class GuiManager implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        InventoryView inv = event.getView();
        ItemStack current = event.getCurrentItem();

        if(event.getCurrentItem() == null) return;

        Managers.getManagers().getRegisteredMenus().values().stream()
                .filter(menu -> inv.getTitle().equalsIgnoreCase(menu.name()))
                .forEach(menu -> {
                    menu.onClick(player, inv, current, event.getSlot());
                    event.setCancelled(true);
                });

    }

    public void addMenu(GuiBuilder m){
        Managers.getManagers().getRegisteredMenus().put(m.getClass(), m);
    }

    public void open(Player player, Class<? extends GuiBuilder> gClass){

        if(!Managers.getManagers().getRegisteredMenus().containsKey(gClass)) return;

        GuiBuilder menu = Managers.getManagers().getRegisteredMenus().get(gClass);
        Inventory inv = Bukkit.createInventory(null, menu.getSize(), menu.name());
        menu.contents(player, inv);

        new BukkitRunnable() {

            @Override
            public void run() {
                player.openInventory(inv);
            }

        }.runTaskLater(Managers.getInstance(), 1);

    }
}
