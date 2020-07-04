package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.PluginTutorielMain;
import fr.volax.plugintutoriel.gui.MenuTutoriel;
import fr.volax.plugintutoriel.tools.GuiBuilder;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

public class Managers {
    private static PluginTutorielMain instance;
    private static Managers managers;
    private GuiManager guiManager;

    private Map<Class<? extends GuiBuilder>, GuiBuilder> registeredMenus;

    public void load(PluginTutorielMain instance) {
        Managers.instance = instance;
        Managers.managers = this;
        this.guiManager = new GuiManager();

        registeredMenus = new HashMap<>();

        instance.saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage("§aLe serveur se lance !");

        CommandsManager.register(instance);
        EventsManager.register(instance);

        guiManager.addMenu(new MenuTutoriel());
    }

    public void unload() {
        Bukkit.getConsoleSender().sendMessage("§cLe serveur se ferme !");
    }

    public static PluginTutorielMain getInstance(){
        return instance;
    }

    public static Managers getManagers(){
        return managers;
    }

    public GuiManager getGuiManager() { return guiManager; }

    public Map<Class<? extends GuiBuilder>, GuiBuilder> getRegisteredMenus() { return registeredMenus; }
}
