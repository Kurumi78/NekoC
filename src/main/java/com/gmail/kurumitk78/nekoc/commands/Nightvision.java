package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import org.bukkit.*;
import org.bukkit.potion.*;

public class Nightvision implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player player = (Player) sender;
        if (NekoC.isNeko(player)) {
            if (args.length == 0) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " On or off?");
            } else if ("on".equalsIgnoreCase(args[0])) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Night vision activated!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 199980, 2));
            } else if ("off".equalsIgnoreCase(args[0])) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Night vision deactivated!");
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        } else {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Only Nekos have night vision!");
        }
        return true;
    }
}
