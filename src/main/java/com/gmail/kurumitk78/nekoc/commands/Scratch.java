package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Scratch implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
                return false;
            }
            final Player send = ((Player)sender).getPlayer();
            if (NekoC.isNeko(send)) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.YELLOW + send.getDisplayName() + ChatColor.LIGHT_PURPLE +" has scratched " +ChatColor.YELLOW +target.getName() + ChatColor.LIGHT_PURPLE+" with sharp claws!");
                }
                else {
                    send.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have scratched " +ChatColor.YELLOW+ target.getDisplayName() +ChatColor.LIGHT_PURPLE+ "!");
                    target.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You feel " + ChatColor.YELLOW +send.getDisplayName() + ChatColor.LIGHT_PURPLE + "'s claws scratch you!");
                }
            }
        }
        return false;
    }
}
