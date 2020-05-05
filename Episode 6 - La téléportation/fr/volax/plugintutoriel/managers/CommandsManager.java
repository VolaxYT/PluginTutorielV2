package fr.volax.plugintutoriel.managers;

import fr.volax.plugintutoriel.PluginTutorielMain;
import fr.volax.plugintutoriel.commands.CommandBroadcast;
import fr.volax.plugintutoriel.commands.CommandSetspawn;
import fr.volax.plugintutoriel.commands.CommandSpawn;
import fr.volax.plugintutoriel.commands.CommandTest;

public class CommandsManager {
    public static void register(PluginTutorielMain instance) {
        instance.getCommand("test").setExecutor(new CommandTest());
        instance.getCommand("broadcast").setExecutor(new CommandBroadcast());
        instance.getCommand("setspawn").setExecutor(new CommandSetspawn());
        instance.getCommand("spawn").setExecutor(new CommandSpawn());
    }
}
