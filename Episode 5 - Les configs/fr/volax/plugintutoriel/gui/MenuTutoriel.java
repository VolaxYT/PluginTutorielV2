package fr.volax.plugintutoriel.gui;

import fr.volax.plugintutoriel.tools.GuiBuilder;
import fr.volax.plugintutoriel.tools.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class MenuTutoriel implements GuiBuilder {
    ItemStack itemTest1 = new ItemBuilder(Material.MELON).setName("Mon item de test !").toItemStack();
    ItemStack itemTest2 = new ItemBuilder(Material.STICK).setLore("§aMon super item !").addEnchant(Enchantment.DAMAGE_ALL, 3).toItemStack();

    @Override
    public String name() {
        return "§bInventaireDeTest";
    }

    @Override
    public int getSize() {
        return 9*2;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        inv.setItem(2, itemTest2);
        inv.setItem(16, itemTest1);
    }

    @Override
    public void onClick(Player player, InventoryView inv, ItemStack current, int slot) {
        if(current.getType() == Material.MELON && current.getItemMeta().getDisplayName().equals("Mon item de test !")){
            player.sendMessage("TEST 1 !");
        }
        if(current.getType() == Material.STICK && current.getItemMeta().getLore().get(0).equals("§aMon super item !")){
            player.sendMessage("TEST 2 !");
        }
    }
}
