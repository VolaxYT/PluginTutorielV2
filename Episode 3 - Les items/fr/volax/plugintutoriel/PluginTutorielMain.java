package fr.volax.plugintutoriel;

import fr.volax.plugintutoriel.managers.Managers;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginTutorielMain extends JavaPlugin {
    Managers managers = new Managers();
    @Override
    public void onEnable() {
        managers.load(this);
    }

    @Override
    public void onDisable() {
        managers.unload();
    }
}
