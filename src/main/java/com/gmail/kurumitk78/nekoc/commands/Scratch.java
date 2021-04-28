package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Scratch implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        final Player player = (Player) sender;
        if (NekoC.isNeko(player)) {
            final Player target = Bukkit.getPlayer(args[0]);
            if (NekoC.globalCommands) {
                Bukkit.broadcastMessage(NekoC.prefix + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has scratched " + ChatColor.YELLOW + target.getName() + ChatColor.LIGHT_PURPLE + " with sharp claws!");
            } else {
                player.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You have scratched " + ChatColor.YELLOW + target.getDisplayName() + ChatColor.LIGHT_PURPLE + "!");
                target.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You feel " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + "'s claws scratch you!");
            }
        }
        return true;
    }
}
