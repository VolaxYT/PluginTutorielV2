package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.PluginTutorielMain;
import org.bukkit.Bukkit;

public class Managers {
    private PluginTutorielMain instance;
    private Managers managers;

    public void load(PluginTutorielMain instance) {
        this.instance = instance;
        this.managers = this;

        Bukkit.getConsoleSender().sendMessage("§aLe serveur se lance !");

        CommandsManager.register(instance);
    }

    public void unload() {
        Bukkit.getConsoleSender().sendMessage("§cLe serveur se ferme !");
    }

    public PluginTutorielMain getInstance(){
        return instance;
    }

    public Managers getManagers(){
        return managers;
    }
}
