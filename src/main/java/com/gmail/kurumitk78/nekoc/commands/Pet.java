package com.gmail.kurumitk78.nekoc.commands;

import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.*;

public class Pet implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0 || Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " Invalid Input");
            return false;
        }
        if (sender.getName().equals(args[0])) {
            sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You cannot pet yourself.");
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        if (NekoC.isNeko(target) && sender instanceof Player) {
            final Player player = (Player) sender;
            if (NekoC.globalCommands) {
                Bukkit.broadcastMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet " + target.getDisplayName());
            } else {
                sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You have pet " + target.getDisplayName());
                target.sendMessage(NekoC.prefix + ChatColor.YELLOW + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has pet you");
            }
        } else {
            sender.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " You can only pet a Neko!");
        }
        return true;
    }
}
