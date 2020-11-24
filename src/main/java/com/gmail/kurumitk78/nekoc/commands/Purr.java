package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Purr implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        final Player player = (Player) sender;
        if (NekoC.isNeko(player)) {
            final Player target = Bukkit.getServer().getPlayer(args[0]);
            if (NekoC.globalCommands) {
                Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " is purring on the feet of " + ChatColor.LIGHT_PURPLE + target.getName());
            } else {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " you purr on " + ChatColor.YELLOW + target.getDisplayName());
                target.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You hear the soft sound of " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + "puring");
            }
        }
        return true;
    }
}
