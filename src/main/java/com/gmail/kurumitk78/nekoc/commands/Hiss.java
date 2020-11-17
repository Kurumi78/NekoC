package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.*;

public class Hiss implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player) {
            final Player send = ((Player)sender).getPlayer();
            if (NekoC.isNeko(send)) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + send.getDisplayName() + ChatColor.LIGHT_PURPLE + " is hissing at " + target.getName());
                }
                else {
                    send.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have hissed at " + target.getName() + "!");
                    target.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You hear " + send.getDisplayName() + ChatColor.LIGHT_PURPLE + " hiss at you!");
                }
            }
        }
        return false;
    }
}
