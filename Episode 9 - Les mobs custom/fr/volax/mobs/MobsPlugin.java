package fr.volax.mobs;

import org.bukkit.plugin.java.JavaPlugin;

public class MobsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("mobs").setExecutor(new MobsCommand());
    }
}
