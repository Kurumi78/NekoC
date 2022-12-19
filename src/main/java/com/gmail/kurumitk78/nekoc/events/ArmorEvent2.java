package com.gmail.kurumitk78.nekoc.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ArmorEvent2 implements Listener{


    @EventHandler
    public void OnItemDrop(PlayerDropItemEvent event){

            ItemStack droppedItem = event.getItemDrop().getItemStack();

            if(droppedItem.hasItemMeta()){
                if(droppedItem.getItemMeta().hasLore()){
                    if(droppedItem.getItemMeta().getLore().contains("§dEnhanced by Catlike Agility")){
                        ItemMeta movedMeta = droppedItem.getItemMeta();
                        List<String> movedLore = movedMeta.getLore();
                        movedLore.remove("§dEnhanced by Catlike Agility");
                        movedMeta.setLore(movedLore);
                        droppedItem.setItemMeta(movedMeta);
                        droppedItem.removeEnchantment(Enchantment.SWIFT_SNEAK);


                    }
                }
            }

        }

    }

