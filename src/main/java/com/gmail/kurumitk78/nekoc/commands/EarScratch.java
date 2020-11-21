package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class EarScratch implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You cannot scratch yourself behind the ear.");
        }
        else if (NekoC.isNeko(Bukkit.getPlayer(args[0]))) {
            if (sender instanceof Player) {
                final Player p = (Player)sender;
                final String PlayerName = p.getDisplayName();
                final Player player = Bukkit.getPlayer(args[0]);
                if (NekoC.globalCommands) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[NekoC] " + ChatColor.YELLOW + ((Player)sender).getDisplayName() + ChatColor.LIGHT_PURPLE + " has scratched behind the ear of " + Bukkit.getPlayer(args[0]).getDisplayName());
                }
                else {
                    sender.sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You have scratched " + ChatColor.YELLOW +PlayerName + ChatColor.LIGHT_PURPLE +" behind the ear");
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
