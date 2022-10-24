package com.gmail.kurumitk78.nekoc;

import com.gmail.kurumitk78.nekoc.commands.*;
import com.gmail.kurumitk78.nekoc.events.*;
import com.gmail.kurumitk78.nekoc.commands.Hiss;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;


public final class NekoC extends JavaPlugin {



    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Config.setConfigDirectory(this.getDataFolder().getAbsolutePath());
        try {
            Config.reloadConfigs();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (Config.Pat) {
            this.getCommand("Pat").setExecutor(new Pat());
        }
        if (Config.Lovebite) {
            this.getCommand("Lovebite").setExecutor(new Lovebite());
        }
        if (Config.Nightvision) {
            this.getCommand("Nightvision").setExecutor(new Nightvision());
        }
        if (Config.Jumpboost) {
            this.getCommand("Jumpboost").setExecutor(new Jumpboost());
        }
        if (Config.Purr) {
            this.getCommand("Purr").setExecutor(new Purr());
        }
        if (Config.Earscratch) {
            this.getCommand("EarScratch").setExecutor(new EarScratch());
        }
        if (Config.Attention) {
            this.getCommand("Attention").setExecutor(new Attention());
        }
        if (Config.Hiss) {
            this.getCommand("Hiss").setExecutor(new Hiss());
        }
        if (Config.Scratch) {
            this.getCommand("Scratch").setExecutor(new Scratch());
        }
        if (Config.NekoChat) {
            Bukkit.getPluginManager().registerEvents(new NekoChat(), this);
        }
        if (Config.MeatOnly) {
            Bukkit.getPluginManager().registerEvents(new MeatOnly(), this);
        }
        if(Config.Catnip){
            Bukkit.getPluginManager().registerEvents(new CatNip(),this);
        }









        //Bukkit.getPluginManager().registerEvents(new CatNip(), this);
        this.getCommand("nekotf").setExecutor(new NekoTF());
        int pluginId = 9164; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId); //This doesn't appear to be used!
    }

    @Override
    public void onDisable() {
            Config.saveAll();
    }
    public static boolean isNeko(final Player p) {
        final String name = p.getUniqueId().toString();
        return Config.NekoList.contains(name);
    }

}
