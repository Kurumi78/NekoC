package com.gmail.kurumitk78.nekoc;

import com.gmail.kurumitk78.nekoc.commands.*;
import com.gmail.kurumitk78.nekoc.events.*;
import com.gmail.kurumitk78.nekoc.commands.Hiss;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.List;

public final class NekoC extends JavaPlugin {
    public FileConfiguration config = this.getConfig();
    public static List<String> nekoListP;
    public static List<String> kittenListP;
    public static boolean globalCommands;


    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        NekoC.globalCommands = config.getBoolean("GlobalCommandMessages");
        NekoC.nekoListP = config.getStringList("Nekos");
        NekoC.kittenListP = config.getStringList("Kittens");
        if (this.config.getBoolean("Pet")) {
            this.getCommand("Pet").setExecutor(new Pet());
        }
        if (this.config.getBoolean("Lovebite")) {
            this.getCommand("Lovebite").setExecutor(new lovebite());
        }
        if (this.config.getBoolean("Nightvision")) {
            this.getCommand("nightvision").setExecutor(new Nightvision());
        }
        if (this.config.getBoolean("Purr")) {
            this.getCommand("Purr").setExecutor(new Purr());
        }
        if (this.config.getBoolean("EarScratch")) {
            this.getCommand("EarScratch").setExecutor(new EarScratch());
        }
        if (this.config.getBoolean("Attention")) {
            this.getCommand("attention").setExecutor(new Attention());
        }
        if (this.config.getBoolean("Hiss")) {
            this.getCommand("hiss").setExecutor(new Hiss());
        }
        if (this.config.getBoolean("Scratch")) {
            this.getCommand("scratch").setExecutor(new Scratch());
        }
        if (this.config.getBoolean("NekoChat")) {
            Bukkit.getPluginManager().registerEvents(new NekoChat(), this);
        }
        if (this.config.getBoolean("MeatOnly")) {
            Bukkit.getPluginManager().registerEvents(new MeatOnly(), this);
        }
        this.getCommand("nekotf").setExecutor(new NekoTF());
        int pluginId = 9164; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static boolean isNeko(final Player p) {
        final String name = p.getName();
        return NekoC.nekoListP.contains(name) || isKitten(p);
    }

    public static boolean isKitten(final Player p) {
        final String name = p.getName();
        return NekoC.kittenListP.contains(name);
    }
}
