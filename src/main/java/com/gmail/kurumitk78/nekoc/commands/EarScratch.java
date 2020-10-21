package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class EarScratch implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You cannot scratch yourself behind the ear.");
        }
        else if (NekoC.isNeko(Bukkit.getPlayer(args[0]))) {
            if (sender instanceof Player) {
                final Player p = (Player)sender;
                final String PlayerName = p.getName();
                final Player player = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.LIGHT_PURPLE + ((Player)sender).getDisplayName() + ChatColor.LIGHT_PURPLE + " has scratched behind the ear of " + Bukkit.getPlayer(args[0]).getDisplayName());
                }
                else {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have scratched " + args[0] + " behind the ear");
                    player.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.YELLOW + PlayerName + ChatColor.LIGHT_PURPLE + " has Scratched you behind the ear");
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + "You can only scratch a Neko behind the ear!");
        }
        return false;
    }
}
