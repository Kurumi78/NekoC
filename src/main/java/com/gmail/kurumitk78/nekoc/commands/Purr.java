package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Purr implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
                return false;
            }
            if (NekoC.isNeko(((Player)sender).getPlayer())) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You pur with no one around.");
                }
                else {
                    final Player p = Bukkit.getServer().getPlayer(args[0]);
                    if (NekoC.globalCommands) {
                        Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + ChatColor.YELLOW+((Player)sender).getPlayer().getDisplayName() + ChatColor.LIGHT_PURPLE + " is purring on the feet of "+ChatColor.LIGHT_PURPLE + p.getName());
                    }
                    else {
                        sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " you purr on " +ChatColor.YELLOW + p.getDisplayName());
                        p.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You hear the soft sound of " +ChatColor.YELLOW+ ((Player)sender).getPlayer().getDisplayName() + ChatColor.LIGHT_PURPLE +"puring");
                    }
                }
            }
            return true;
        }
        return false;
    }
}
