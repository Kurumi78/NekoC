package com.gmail.kurumitk78.nekoc;

import com.gmail.kurumitk78.nekoc.commands.*;
import com.gmail.kurumitk78.nekoc.events.*;
import com.gmail.kurumitk78.nekoc.commands.Hiss;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;
import java.util.ArrayList; //Appears not to be used in file
import java.util.List;

public final class NekoC extends JavaPlugin {
    public FileConfiguration config;
    public static List<String> nekoListP;
    public static boolean globalCommands;
    public static String prefix = "test";


    @Override
    public void onEnable() {



        if (!(new File(this.getDataFolder(), "config.yml").exists())) { // Generates the config if missing,
            this.saveDefaultConfig();
        }
        config = this.getConfig();





        NekoC.globalCommands = config.getBoolean("GlobalCommandMessages");
        NekoC.nekoListP = config.getStringList("Nekos");
        if (this.config.getBoolean("Pat")) {
            this.getCommand("Pat").setExecutor(new Pat());
        }
        if (this.config.getBoolean("Lovebite")) {
            this.getCommand("Lovebite").setExecutor(new Lovebite());
        }
        if (this.config.getBoolean("Nightvision")) {
            this.getCommand("Nightvision").setExecutor(new Nightvision());
        }
        if (this.config.getBoolean("Purr")) {
            this.getCommand("Purr").setExecutor(new Purr());
        }
        if (this.config.getBoolean("Earscratch")) {
            this.getCommand("EarScratch").setExecutor(new EarScratch());
        }
        if (this.config.getBoolean("Attention")) {
            this.getCommand("Attention").setExecutor(new Attention());
        }
        if (this.config.getBoolean("Hiss")) {
            this.getCommand("Hiss").setExecutor(new Hiss());
        }
        if (this.config.getBoolean("Scratch")) {
            this.getCommand("Scratch").setExecutor(new Scratch());
        }
        if (this.config.getBoolean("NekoChat")) {
            Bukkit.getPluginManager().registerEvents(new NekoChat(), this);
        }
        if (this.config.getBoolean("MeatOnly")) {
            Bukkit.getPluginManager().registerEvents(new MeatOnly(), this);
        }
        if(this.config.getBoolean("Catnip")){
            Bukkit.getPluginManager().registerEvents(new CatNip(),this);
        }

        prefix = ChatColor.translateAlternateColorCodes('&', config.getString("PluginPrefix"));


        //Name to UUID conversion
        for(int i = 0; i < nekoListP.size(); i++){
            Bukkit.getLogger().info("Checking if " + nekoListP.get(0) );
            if (!nekoListP.get(i).matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")) {
                Bukkit.getLogger().info("Is not UUID");
                nekoListP.set(i, uuidConvert(nekoListP.get(i)));
            }
            config.set("Nekos", nekoListP);
            this.saveConfig();
        }






        //Bukkit.getPluginManager().registerEvents(new CatNip(), this);
        this.getCommand("nekotf").setExecutor(new NekoTF());
        int pluginId = 9164; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId); //This doesn't appear to be used!
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static boolean isNeko(final Player p) {
        final String name = p.getUniqueId().toString();
        return NekoC.nekoListP.contains(name);
    }

    public static String uuidConvert(final String name) {
        Bukkit.getLogger().info("Converting" + name + "toUUID");
        OfflinePlayer p = Bukkit.getOfflinePlayer(name); //Deprecated! Persistent storage of users should be by UUID as names are no longer unique past a single session
        return p.getUniqueId().toString();

    }
}
