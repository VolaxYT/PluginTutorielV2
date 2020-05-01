package fr.volax.plugintutoriel.tools;

import fr.volax.plugintutoriel.managers.Managers;

import java.util.List;

public class ConfigBuilder {
    public static String getString(String value){ return Managers.getInstance().getConfig().getString(value).replaceAll("&","§"); }

    public static int getInt(String value){
        return Managers.getInstance().getConfig().getInt(value);
    }

    public static boolean getBoolean(String value){ return Managers.getInstance().getConfig().getBoolean(value); }

    public static List getList(String value){
        return Managers.getInstance().getConfig().getList(value);
    }

    public static double getDouble(String value){
        return Managers.getInstance().getConfig().getDouble(value);
    }

    public static void set(String value, String data){
        Managers.getInstance().getConfig().set(value, data);
        Managers.getInstance().saveConfig();
        Managers.getInstance().reloadConfig();
    }

    public static void reload(){ Managers.getInstance().reloadConfig(); }
}
