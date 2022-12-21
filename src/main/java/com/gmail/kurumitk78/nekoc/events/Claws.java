package com.gmail.kurumitk78.nekoc.events;

import com.gmail.kurumitk78.nekoc.Config;
import com.gmail.kurumitk78.nekoc.NekoC;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Claws implements Listener{

    @EventHandler
    public void OnPlayerAttack(final EntityDamageByEntityEvent event){

        if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){
            Player damager = ((Player) event.getDamager()).getPlayer();
            LivingEntity damagee = (LivingEntity) event.getEntity();
            if(NekoC.isNeko(damager) && damager.getInventory().getItemInMainHand().getType().isAir()){
                int randomchance = (int) (Math.random() * (100 - 1) + 1);
                if(randomchance <= Config.ClawPoisonChance){
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Config.ClawPoisonDuration, Config.ClawPoisonLevel-1));
                }
                event.setDamage(Config.ClawDamage);

            }


        }

    }


}
