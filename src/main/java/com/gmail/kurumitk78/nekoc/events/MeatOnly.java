package com.gmail.kurumitk78.nekoc.events;

import java.util.*;

import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class MeatOnly implements Listener
{
    public static ArrayList<String> edibleForCat = (ArrayList<String>) Bukkit.getPluginManager().getPlugin("NekoC").getConfig().getList("UnedibleForCat");

    @EventHandler
    public void onPlayerInteract(final PlayerItemConsumeEvent event) {
        if (NekoC.isNeko(event.getPlayer().getPlayer())) {
            String myMat;
            if (event.getItem() != null) {
                myMat = event.getItem().getType().toString();
                if (MeatOnly.edibleForCat.contains(myMat)) {
                    event.getPlayer().sendMessage(ChatColor.GREEN + "[NekoC]" + ChatColor.LIGHT_PURPLE + " You cannot eat that silly kitty.");
                    event.setCancelled(true);
                }
                else if (myMat.equals("COD") || myMat.equals("SALMON") || myMat.equals("TROPICAL_FISH") || myMat.equals("RAW_FISH")) {
                    final Player p = event.getPlayer();
                    p.setFoodLevel(p.getFoodLevel() + 4);
                    p.setSaturation(p.getSaturation() + 9.4f);
                }
            }

        }
    }

}
