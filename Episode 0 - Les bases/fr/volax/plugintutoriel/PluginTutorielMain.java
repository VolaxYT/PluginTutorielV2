package fr.volax.plugintutoriel;

import fr.volax.plugintutoriel.utils.Managers;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginTutorielMain extends JavaPlugin {
    @Override
    public void onEnable() {
        Managers.load();
    }

    @Override
    public void onDisable() {
        Managers.unload();
    }
}
