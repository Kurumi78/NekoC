package com.gmail.kurumitk78.nekoc.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ArmorEvent implements Listener {

    @EventHandler
    public void ArmorChange(final InventoryClickEvent event){
        if(event.getCurrentItem() != null && event.getWhoClicked() instanceof Player){  //Todo, not this
            ItemStack movedItem = event.getCurrentItem();
            if(movedItem.hasItemMeta()){
                if(movedItem.getItemMeta().hasLore()){
                    if(movedItem.getItemMeta().getLore().contains("§dEnhanced by Catlike Agility")){
                        ItemMeta movedMeta = movedItem.getItemMeta();
                        List<String> movedLore = movedMeta.getLore();
                        movedLore.remove("§dEnhanced by Catlike Agility");
                        movedMeta.setLore(movedLore);
                        movedItem.setItemMeta(movedMeta);
                        movedItem.removeEnchantment(Enchantment.SWIFT_SNEAK);
                        event.setCurrentItem(movedItem);

                    }
                }
            }

        }
    }

}
