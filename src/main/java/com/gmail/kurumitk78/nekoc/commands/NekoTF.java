package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class NekoTF implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (commandSender.hasPermission("NekoC.NekoTF")) {
            if (args.length == 0) {
                final Player commandTarget = ((Player)commandSender).getPlayer();
                if (!NekoC.isNeko(commandTarget)) {
                    NekoC.nekoListP.add(commandTarget.getName());
                    Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", (Object)NekoC.nekoListP);
                    Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                    commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Made you a neko!");
                }
                else {
                    NekoC.nekoListP.remove(commandTarget.getName());
                    Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", (Object)NekoC.nekoListP);
                    Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                    commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You are no longer a neko!");
                }
            }
            else if (commandSender.hasPermission("nekoC.Admin")) {
                final Player commandTarget = Bukkit.getPlayer(args[0]);
                if (commandTarget.isValid()) {
                    if (!NekoC.isNeko(commandTarget)) {
                        NekoC.nekoListP.add(args[0]);
                        Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", (Object)NekoC.nekoListP);
                        commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Made " + args[0] + " a neko!");
                        Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                    }
                    else {
                        NekoC.nekoListP.remove(commandTarget.getName());
                        Bukkit.getPluginManager().getPlugin("NekoC").getConfig().set("Nekos", (Object)NekoC.nekoListP);
                        commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " " + args[0] + " is no longer a neko!");
                        Bukkit.getPluginManager().getPlugin("NekoC").saveConfig();
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Player does not exist!");
                }
            }
        }
        return false;
    }
}
