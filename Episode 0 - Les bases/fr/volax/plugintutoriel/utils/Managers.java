package fr.volax.plugintutoriel.utils;

import org.bukkit.Bukkit;

public class Managers {
    /**
     * Sert à executer toute les fonctions de notre plugin quand le serveur se lance
     */
    public static void load() {
        // Envois d'un message à la console quand le serveur se lance
        Bukkit.getConsoleSender().sendMessage("§aLe serveur se lance !");
    }

    /**
     * Sert à executer toute les fonctions de notre plugin quand le serveur se ferme
     */
    public static void unload() {
        // Envois d'un message à la console quand le serveur se ferme
        Bukkit.getConsoleSender().sendMessage("§cLe serveur se ferme !");
    }
}
