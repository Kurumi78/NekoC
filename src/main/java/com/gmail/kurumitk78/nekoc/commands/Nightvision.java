package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import org.bukkit.*;
import org.bukkit.potion.*;

public class Nightvision implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (NekoC.isNeko(((Player)sender).getPlayer())) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " On or off?");
                }
                else if (args[0].equals("on")) {
                    final Player player = ((Player)sender).getPlayer();
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Nightvision Activated!");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 199980, 2));
                }
                else if (args[0].equals("off")) {
                    final Player player = ((Player)sender).getPlayer();
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Nightvision Deactivated!");
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                }
            }
            else {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Only Nekos have Nightvision!");
            }
        }
        return true;
    }
}
