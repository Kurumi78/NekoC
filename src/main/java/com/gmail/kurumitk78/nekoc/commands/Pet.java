package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class Pet implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You cannot pet yourself.");
        }
        else if (NekoC.isNeko(Bukkit.getPlayer(args[0]))) {
            if (sender instanceof Player) {
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + ((Player)sender).getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet " + Bukkit.getPlayer(args[0]).getDisplayName());
                }
                else {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have pet " + Bukkit.getPlayer(args[0]).getDisplayName());
                    Bukkit.getPlayer(args[0]).sendMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.YELLOW + ((Player)sender).getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet you");
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You can only pet a Neko!");
        }
        return true;
    }
}
