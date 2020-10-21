package com.gmail.kurumitk78.nekoc.events;

import java.util.*;

import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class MeatOnly implements Listener
{
    public static ArrayList<Material> edibleForCat = (ArrayList<Material>) Bukkit.getPluginManager().getPlugin("NekoC").getConfig().getList("UnedibleForCat");

    @EventHandler
    public void onPlayerInteract(final PlayerItemConsumeEvent event) {
        if (NekoC.isNeko(event.getPlayer().getPlayer())) {
            Material myMat;
            if (event.getItem() != null) {
                myMat = event.getItem().getType();
            }
            else {
                myMat = Material.AIR;
            }
            if (MeatOnly.edibleForCat.contains(myMat)) {
                event.getPlayer().sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You cannot eat that silly kitty.");
                event.setCancelled(true);
            }
            else if (myMat.equals((Object)Material.COD) || myMat.equals((Object)Material.SALMON) || myMat.equals((Object)Material.TROPICAL_FISH)) {
                final Player p = event.getPlayer();
                p.setFoodLevel(p.getFoodLevel() + 4);
                p.setSaturation(p.getSaturation() + 9.4f);
            }
        }
    }

    public static void registerUnedibleItems() {




        /*
        MeatOnly.edibleForCat.add(Material.APPLE);        //This is the legacy way I accomplished this.
        MeatOnly.edibleForCat.add(Material.MUSHROOM_STEW);
        MeatOnly.edibleForCat.add(Material.BREAD);
        MeatOnly.edibleForCat.add(Material.GOLDEN_APPLE);
        MeatOnly.edibleForCat.add(Material.ENCHANTED_GOLDEN_APPLE);
        MeatOnly.edibleForCat.add(Material.MELON_SLICE);
        MeatOnly.edibleForCat.add(Material.DRIED_KELP);
        MeatOnly.edibleForCat.add(Material.CARROT);
        MeatOnly.edibleForCat.add(Material.POTATO);
        MeatOnly.edibleForCat.add(Material.BAKED_POTATO);
        MeatOnly.edibleForCat.add(Material.POISONOUS_POTATO);
        MeatOnly.edibleForCat.add(Material.PUMPKIN_PIE);
        MeatOnly.edibleForCat.add(Material.BEETROOT);
        MeatOnly.edibleForCat.add(Material.BEETROOT_SOUP);
        MeatOnly.edibleForCat.add(Material.SWEET_BERRIES);

         */
    }

    static {
        MeatOnly.edibleForCat = new ArrayList<Material>();
    }
}
