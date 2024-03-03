package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
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
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        final Player player = (Player) sender;
        if (NekoC.isNeko(player)) {
            final Player target = Bukkit.getServer().getPlayer(args[0]);
            if (Config.GlobalCommandMessages) {
                Bukkit.broadcastMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " is purring on the feet of " + ChatColor.LIGHT_PURPLE + target.getName());
            } else {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " you purr on " + ChatColor.YELLOW + target.getDisplayName());
                target.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You hear the soft sound of " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " purring");
            }
            if(Config.CommandSounds){
                target.playSound(target.getLocation(), Sound.ENTITY_CAT_PURR, 5, 1);
            }
        }
        return true;
    }
}
