package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.PluginTutorielMain;
import fr.volax.plugintutoriel.listeners.PlayersEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {
    public static void register(PluginTutorielMain instance) {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayersEvent(), instance);
        pm.registerEvents(new GuiManager(), instance);
    }
}
