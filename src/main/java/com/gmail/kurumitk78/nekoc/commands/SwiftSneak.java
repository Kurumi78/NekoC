package com.gmail.kurumitk78.nekoc.commands;

import com.gmail.kurumitk78.nekoc.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwiftSneak implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ItemStack pants = ((Player)commandSender).getInventory().getLeggings();

        if(pants != null){
            ItemMeta pantsMeta = pants.getItemMeta();
            if(pants.getItemMeta().hasEnchant(Enchantment.SWIFT_SNEAK)){
                commandSender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You already have the SwiftSneak enchantment, your catlike agility does nothing.");
            }
            else{
                List<String> loreList = new ArrayList<String>();
                if(pantsMeta.hasLore()) {
                    loreList = pantsMeta.getLore();
                }
                loreList.add("§dEnhanced by Catlike Agility");
                pantsMeta.setLore(loreList);
                pants.setItemMeta(pantsMeta);
                pants.addUnsafeEnchantment(Enchantment.SWIFT_SNEAK, 3);
                commandSender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You have started sneaking with your catlike agility");
            }
        }
        else{
            commandSender.sendMessage(Config.PluginPrefix + ChatColor.LIGHT_PURPLE + " You feel uncomfortable trying to sneak around without pants on.");

        }



        return false;
    }
}
