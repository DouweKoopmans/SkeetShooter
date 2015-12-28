package com.fallingdutchman.SkeetShooter.Listeners;

import com.fallingdutchman.SkeetShooter.SkeetShooter;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by FallingDutchman on 27-12-15.
 */
public class GameEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void PlayerRightClick(PlayerInteractEvent event) {
        SkeetShooter.getCORE().fireProjectile(event.getPlayer());
        SkeetShooter.getCORE().fireSkeet(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void skeetHit(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Pig) {
            Player p = (Player) event.getDamager();
            Pig skeet = ((Pig) event.getEntity());

            SkeetShooter.getCORE().skeetHit(p, skeet, p.getLocation());
        }
    }
}