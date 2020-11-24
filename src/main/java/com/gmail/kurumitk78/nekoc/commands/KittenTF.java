package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;
import org.bukkit.entity.*;

public class KittenTF implements CommandExecutor {
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (!commandSender.hasPermission("NekoC.KittenTF")) {
            return false;
        }
        final Player commandTarget = Bukkit.getPlayer(args[0]);
        if (commandTarget.isValid()) {
            if (!NekoC.isKitten(commandTarget)) {
                NekoC.kittenListP.add(args[0]);
                Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Kittens", NekoC.kittenListP);
                commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Made " + ChatColor.YELLOW + commandTarget.getDisplayName() + " a kitten!");
            } else {
                NekoC.kittenListP.remove(commandTarget.getName());
                Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Kittens", NekoC.kittenListP);
                commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " " + ChatColor.YELLOW + commandTarget.getDisplayName() + " is no longer a kitten!");
            }
            Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
        } else {
            commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Player does not exist!");
        }
        return true;
    }
}
