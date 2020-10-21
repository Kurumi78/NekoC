package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class lovebite implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (NekoC.isNeko(Bukkit.getPlayer(args[0]))) {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + "Nekos cant lovebite another neko!");
            }
            else {
                final Player p = (Player)sender;
                final String PlayerName = p.getName();
                final Player player = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + p.getDisplayName() + ChatColor.LIGHT_PURPLE + " has lightly bit the finger of " + player.getName());
                }
                else {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You lightly bite the finger of " + args[0] + " to show them how much you love them.");
                    player.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.YELLOW + "You feel a sharp set of teeth softly bite your finger, then see" + PlayerName + " looking up at you.");
                }
            }
        }
        return true;
    }
}
