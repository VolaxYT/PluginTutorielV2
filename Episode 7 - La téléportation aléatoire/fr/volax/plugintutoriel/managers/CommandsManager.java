package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.PluginTutorielMain;
import fr.volax.plugintutoriel.commands.*;

public class CommandsManager {
    public static void register(PluginTutorielMain instance) {
        instance.getCommand("test").setExecutor(new CommandTest());
        instance.getCommand("broadcast").setExecutor(new CommandBroadcast());
        instance.getCommand("setspawn").setExecutor(new CommandSetspawn());
        instance.getCommand("spawn").setExecutor(new CommandSpawn());
        instance.getCommand("randomtp").setExecutor(new CommandRandomTP());
        instance.getCommand("coordonnees").setExecutor(new CommandCoordonnees());
        instance.getCommand("setcoordonnees").setExecutor(new CommandSetCoordonnees());
    }
}
