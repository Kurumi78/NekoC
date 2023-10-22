package com.gmail.kurumitk78.nekoc;

import jdk.jfr.internal.LogLevel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

public class Config {

    private static String configDirectory;  //A string containing the directory of the config files

    public static String PluginPrefix;  //Some variables containing what was in the Config File
    public static boolean NekoChat;
    public static boolean MeatOnly;
    public static boolean Catnip;
    public static boolean Pat;
    public static boolean Lovebite;
    public static boolean Nightvision;

    public static boolean Jumpboost;

    public static boolean Swiftsneak;

    public static int SwiftsneakLevel;

    public static boolean Claws;

    public static int ClawPoisonLevel;

    public static int ClawPoisonDuration;

    public static int ClawPoisonChance;

    public static double ClawDamage;

    public static boolean ClawDamageAdditive;
    public static boolean Purr;
    public static boolean Earscratch;
    public static boolean Attention;
    public static boolean Hiss;
    public static boolean Scratch;
    public static boolean GlobalCommandMessages;
    public static ArrayList<String> inedibleForCat = null;
    public static ArrayList<String> NekoList =  null;

    public static boolean permChecks;



    private static YamlConfiguration mainConfig = null;
    private static YamlConfiguration nekoListConfig = null;


    private static final String mainConfigFileName = "/config.yml"; //Set the name of the Main Config file
    private static final String nekoListConfigFileName = "/NekoList.yml";


    public static void setConfigDirectory(String configDirectory){
        Config.configDirectory = configDirectory;
    }

    public static void saveAll() { //This method saves the Nekolist config file
        try{
            nekoListConfig.set("Nekos", NekoList);
           // mainConfig.save(configDirectory + mainConfigFileName); //Save the  main config file
            nekoListConfig.save(configDirectory + nekoListConfigFileName);

        } catch(IOException e){ //catches if the config file doesnt exist. Figure out why you print the stack trace manually.
            e.printStackTrace();
        }
    }

    public static void reloadConfigs() throws IOException {

        mainConfig  = new YamlConfiguration();
        nekoListConfig = new YamlConfiguration();

        // defaultConfigs();

        try{
            mainConfig.load(configDirectory + mainConfigFileName); //Load the config from disk
            nekoListConfig.load(configDirectory + nekoListConfigFileName);
        }catch(InvalidConfigurationException | IOException ignored){ //Catch to catch if cant load the config files

            Bukkit.getLogger().severe("NekoC failed to load all of its configs!");

        }

        if(mainConfig.get("ConfigVersion") == null){
            Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.0");
            NekoList = new ArrayList<String>(mainConfig.getStringList("Nekos"));
            mainConfig.set("Nekos", null);
            nekoListConfig.set("Nekos", NekoList);
            inedibleForCat = new ArrayList<String>(mainConfig.getStringList("UnedibleForCat"));
            mainConfig.set("UnedibleForCat", null);
            mainConfig.set("InedibleForCat", inedibleForCat);
            mainConfig.set("ConfigVersion", 1.0);
            mainConfig.save(configDirectory + mainConfigFileName);
        }
        if(mainConfig.get("ConfigVersion").equals(1.0)){
            Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.1");
            mainConfig.set("Jumpboost", true);
            mainConfig.set("SwiftSneak", true);
            mainConfig.set("ConfigVersion", 1.1);
            mainConfig.save(configDirectory + mainConfigFileName);
        }
        if(mainConfig.get("ConfigVersion").equals(1.1)) {Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.2");mainConfig.set("Claws", true);
        mainConfig.set("Claw Poison Level", 1);
        mainConfig.set("Claw Poison Duration", 10);
        mainConfig.set("Claw Poison Chance", 25);
        mainConfig.set("Claw Damage", 1);
        mainConfig.set("ConfigVersion", 1.2);
        mainConfig.save(configDirectory + mainConfigFileName);
        }
        if(mainConfig.get("ConfigVersion").equals(1.2)){
            Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.3");
            mainConfig.set("Claw Damage Additive", false);
            mainConfig.set("ConfigVersion", 1.3);
            mainConfig.save(configDirectory + mainConfigFileName);
        }
        if(mainConfig.get("ConfigVersion").equals(1.3)){
            Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.4");
            mainConfig.set("Permission based Neko Checking", false);
            mainConfig.set("ConfigVersion", 1.4);
            mainConfig.save(configDirectory + mainConfigFileName);

        }
        if(mainConfig.get("ConfigVersion").equals(1.4)){
            Bukkit.getLogger().log(Level.INFO, "[NekoC] Updating config to 1.5");
            mainConfig.set("Permission based Neko Checking", false);
            mainConfig.set("ConfigVersion", 1.5);
            mainConfig.save(configDirectory + mainConfigFileName);

        }


         PluginPrefix = ChatColor.translateAlternateColorCodes('&', mainConfig.getString("PluginPrefix"));
         NekoChat = mainConfig.getBoolean("NekoChat");
         MeatOnly = mainConfig.getBoolean("MeatOnly");
         Catnip = mainConfig.getBoolean("Catnip");
         Pat = mainConfig.getBoolean("Pat");
         Lovebite = mainConfig.getBoolean("Lovebite");
         Nightvision = mainConfig.getBoolean("Nightvision");
         Jumpboost = mainConfig.getBoolean("Jumpboost");
         Swiftsneak = mainConfig.getBoolean("SwiftSneak");
         SwiftsneakLevel= mainConfig.getInt("SwiftSneak Level");
         Purr = mainConfig.getBoolean("Purr");
         Earscratch = mainConfig.getBoolean("Earscratch");
         Attention = mainConfig.getBoolean("Attention");
         Hiss = mainConfig.getBoolean("Hiss");
         Scratch = mainConfig.getBoolean("Scratch");
         Claws = mainConfig.getBoolean("Claws");
         ClawPoisonLevel = mainConfig.getInt("Claw Poison Level");
         ClawPoisonDuration = mainConfig.getInt("Claw Poison Duration");
         ClawPoisonChance = mainConfig.getInt("Claw Poison Chance");
         ClawDamage = mainConfig.getDouble("Claw Damage");
         ClawDamageAdditive = mainConfig.getBoolean("Claw Damage Additive");
         GlobalCommandMessages = mainConfig.getBoolean("GlobalCommandMessages");
         NekoList =  new ArrayList<String>(nekoListConfig.getStringList("Nekos"));
         inedibleForCat = new ArrayList<String>(mainConfig.getStringList("InedibleForCat"));
         permChecks = mainConfig.getBoolean("Permission based Neko Checking");


        for(int i = 0; i < NekoList.size(); i++){
            if (!NekoList.get(i).matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")) {
                NekoList.set(i, uuidConvert(NekoList.get(i)));
            }
        }
    }
    public static String uuidConvert(final String name) {
        Bukkit.getLogger().info("Converting " + name + " toUUID");
        OfflinePlayer p = Bukkit.getOfflinePlayer(name); //Yes the method is depreciated. It's fine in this use case, im not using it to store data, just converting the player name to UUID.
        return p.getUniqueId().toString();

    }

}
