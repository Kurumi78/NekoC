package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Scratch implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player) {
            final Player send = ((Player)sender).getPlayer();
            if (NekoC.isNeko(send)) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + send.getDisplayName() + " has scratched " + target.getName() + " with sharp claws!");
                }
                else {
                    send.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have scratched " + target.getName() + "!");
                    target.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You feel " + send.getDisplayName() + ChatColor.LIGHT_PURPLE + "'s claws scratch you!");
                }
            }
        }
        return false;
    }
}
