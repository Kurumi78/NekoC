package com.gmail.kurumitk78.nekoc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.util.*;

public class Config {

    private static String configDirectory;  //A string containing the directory of the config files

    public static String PluginPrefix;  //Some variables containing what was in the Config File
    public static boolean NekoChat;
    public static boolean MeatOnly;
    public static boolean Catnip;
    public static boolean Pat;
    public static boolean Lovebite;
    public static boolean Nightvision;
    public static boolean Purr;
    public static boolean Earscratch;
    public static boolean Attention;
    public static boolean Hiss;
    public static boolean Scratch;
    public static boolean GlobalCommandMessages;
    public static ArrayList<String> inedibleForCat = null;
    public static ArrayList<String> NekoList =  null;



    private static YamlConfiguration mainConfig = null;
    private static YamlConfiguration nekoListConfig = null;


    private static final String mainConfigFileName = "/Config.yml"; //Set the name of the Main Config file
    private static final String nekoListConfigFileName = "/NekoList.yml";


    public static void setConfigDirectory(String configDirectory){
        Config.configDirectory = configDirectory;
    }

    public static void saveAll() { //This method saves all config files
        try{
            nekoListConfig.set("Nekos", NekoList);
            mainConfig.save(configDirectory + mainConfigFileName); //Save the config file
            nekoListConfig.save(configDirectory + nekoListConfigFileName);

        } catch(IOException e){ //catches if the config file doesnt exist. Figure out why you print the stack trace manually.
            e.printStackTrace();
        }
    }

    public static void reloadConfigs(){

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
            NekoList = new ArrayList<String>(mainConfig.getStringList("Nekos"));
            mainConfig.set("Nekos", null);
            nekoListConfig.set("Nekos", NekoList);
            inedibleForCat = new ArrayList<String>(mainConfig.getStringList("UnedibleForCat"));
            mainConfig.set("UnedibleForCat", null);
            mainConfig.set("InedibleForCat", inedibleForCat);
            mainConfig.set("ConfigVersion", 1.0);
            Config.saveAll();
        }

         PluginPrefix = ChatColor.translateAlternateColorCodes('&', mainConfig.getString("PluginPrefix"));
         NekoChat = mainConfig.getBoolean("NekoChat");
         MeatOnly = mainConfig.getBoolean("MeatOnly");
         Catnip = mainConfig.getBoolean("Catnip");
         Pat = mainConfig.getBoolean("Pat");
         Lovebite = mainConfig.getBoolean("Lovebite");
         Nightvision = mainConfig.getBoolean("Nightvision");
         Purr = mainConfig.getBoolean("Purr");
         Earscratch = mainConfig.getBoolean("Earscratch");
         Attention = mainConfig.getBoolean("Attention");
         Hiss = mainConfig.getBoolean("Hiss");
         Scratch = mainConfig.getBoolean("Scratch");
         GlobalCommandMessages = mainConfig.getBoolean("GlobalCommandMessages");
         NekoList =  new ArrayList<String>(nekoListConfig.getStringList("Nekos"));
         inedibleForCat = new ArrayList<String>(mainConfig.getStringList("InedibleForCat"));


        for(int i = 0; i < NekoList.size(); i++){
            if (!NekoList.get(i).matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")) {
                NekoList.set(i, uuidConvert(NekoList.get(i)));
            }
        }


    }

    private static void defaultConfigs(){

        HashMap <String, Object > defaults = new HashMap<>(); //Create a hashmap for the defaults
        defaults.put("PluginPrefix", "&a[NekoC]"); //add the defaults to the hashmap
        defaults.put("NekoChat", true);
        defaults.put("MeatOnly", true);
        defaults.put("Catnip", true);
        defaults.put("Pat", true);
        defaults.put("Lovebite", true);
        defaults.put("NightVision", true);
        defaults.put("Purr", true);
        defaults.put("EarScratch", true);
        defaults.put("Attention", true);
        defaults.put("Hiss", true);
        defaults.put("Scratch", true);
        defaults.put("GlobalCommandMessages", true);
        defaults.put("InedibleForCat", Arrays.asList("Apple", "MUSHROOM_STEW","BREAD", "GOLDEN_APPLE", "ENCHANTED_GOLDEN_APPLE", "MELON_SLICE","DRIED_KELP","CARROT","POTATO","BAKED_POTATO","POISONOUS_POTATO","PUMPKIN_PIE","BEETROOT","BEETROOT_SOUP","SWEET_BERRIES","CARROT_ITEM","POTATO_ITEM","MELON"));

        for (Map.Entry <String, Object> entry:defaults.entrySet()){

            if(mainConfig.get(entry.getKey()) == null){ //Try to get a value from the current entry key, continue if null
                mainConfig.set(entry.getKey(), entry.getValue()); //Gets the value from the hashmap of defaults and adds it to the config in memory
            }
        }

        if(nekoListConfig.get("Nekos").toString().length()== 0){
            nekoListConfig.set("Nekos", Arrays.asList("Kurumi78"));
        }


    }
    public static String uuidConvert(final String name) {
        Bukkit.getLogger().info("Converting" + name + "toUUID");
        OfflinePlayer p = Bukkit.getOfflinePlayer(name); //Yes the method is depreciated. It's fine in this use case, im not using it to store data, just converting the player name to UUID.
        return p.getUniqueId().toString();

    }

}
