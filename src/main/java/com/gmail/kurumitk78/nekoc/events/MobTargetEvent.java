package com.gmail.kurumitk78.nekoc.events;

import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class MobTargetEvent implements Listener {

    @EventHandler
    public void onMobTarget(EntityTargetEvent event){
        if(event.getEntityType() == EntityType.CREEPER && event.getTarget().getType() == EntityType.PLAYER){
            if(NekoC.isNeko((Player)event.getTarget())){
                event.setCancelled(true);
            }
        }

    }
}
