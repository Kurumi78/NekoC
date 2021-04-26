package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class NekoTF implements CommandExecutor {
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (!commandSender.hasPermission("NekoC.NekoTF")) {
            return false;
        }
        if (args.length == 0) {
            final Player commandTarget = ((Player) commandSender).getPlayer();
            if (!NekoC.isNeko(commandTarget)) {
                NekoC.nekoListP.add(commandTarget.getUniqueId().toString());
                Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", NekoC.nekoListP);
                Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Made you a neko!");
            } else {
                NekoC.nekoListP.remove(commandTarget.getUniqueId().toString());
                Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", NekoC.nekoListP);
                Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You are no longer a neko!");
            }
        } else if (commandSender.hasPermission("nekoC.Admin")) {
            final Player commandTarget = Bukkit.getPlayer(args[0]);
            if (commandTarget.isValid()) {
                if (!NekoC.isNeko(commandTarget)) {
                    NekoC.nekoListP.add(Bukkit.getPlayer(args[0]).getUniqueId().toString());
                    Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", NekoC.nekoListP);
                    commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Made " + ChatColor.YELLOW + commandTarget.getDisplayName() + " a neko!");
                } else {
                    NekoC.nekoListP.remove(Bukkit.getPlayer(args[0]).getUniqueId().toString());
                    Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", NekoC.nekoListP);
                    commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " " + ChatColor.YELLOW + commandTarget.getDisplayName() + " is no longer a neko!");
                }
                Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
            } else {
                commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Player does not exist!");
            }
        }
        return true;
    }
}
