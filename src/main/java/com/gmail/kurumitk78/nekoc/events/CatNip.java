package com.gmail.kurumitk78.nekoc.events;

import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CatNip implements Listener {


    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (event.getMaterial().equals(Material.SEEDS) && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("catnip")) {

            if (NekoC.isNeko(event.getPlayer())){
                Player p = event.getPlayer();
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15*20, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 15*20, 30));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 15*20, 5));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10*20, 1));

                ItemStack newNip = p.getInventory().getItemInMainHand();
                newNip.setAmount(newNip.getAmount()-1);
                p.getInventory().setItemInMainHand(newNip);
                p.sendMessage(NekoC.prefix + ChatColor.LIGHT_PURPLE + " Catnip Consumed!");
                return;


            }

        }

    }
}
