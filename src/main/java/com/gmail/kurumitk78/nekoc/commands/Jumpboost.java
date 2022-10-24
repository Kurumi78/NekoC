package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Jumpboost implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " This command is only for Players");
            return false;
        }
        final Player player = (Player) sender;
        if (NekoC.isNeko(player)) {
            if (args.length == 0) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " On or off?");
            } else if ("on".equalsIgnoreCase(args[0])) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Jump Boost activated!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 199980, 2));
            } else if ("off".equalsIgnoreCase(args[0])) {
                sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Jump Boost deactivated!");
                player.removePotionEffect(PotionEffectType.JUMP);
            }
        } else {
            sender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " Only Nekos have Jump Boost!");
        }
        return true;
    }
}
