package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Hiss implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }

        final Player target = Bukkit.getPlayer(args[0]);
        final Player player = ((Player) sender).getPlayer();
        if (NekoC.isNeko(player)) {
            if (NekoC.globalCommands) {
                Bukkit.broadcastMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " is hissing at " + target.getName());
            } else {
                player.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You have hissed at " + ChatColor.YELLOW + target.getDisplayName() + "!");
                target.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You hear " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " hiss at you!");
            }
        }
        else{player.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " Only Nekos can hiss" + "!");}

        return true;
    }
}
