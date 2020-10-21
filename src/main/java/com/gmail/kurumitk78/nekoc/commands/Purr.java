package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Purr implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (NekoC.isNeko(((Player)sender).getPlayer())) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You pur with no one around.");
                }
                else {
                    final Player p = Bukkit.getServer().getPlayer(args[0]);
                    if (NekoC.globalCommands) {
                        Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + ((Player)sender).getPlayer().getDisplayName() + ChatColor.LIGHT_PURPLE + " is purring on the feet of " + p.getName());
                    }
                    else {
                        sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " you purr on " + args[0]);
                        p.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You hear the soft sound of " + ((Player)sender).getPlayer().getDisplayName() + "puring");
                    }
                }
            }
            return true;
        }
        return false;
    }
}
