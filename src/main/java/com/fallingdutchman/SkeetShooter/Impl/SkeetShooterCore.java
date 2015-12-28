package com.fallingdutchman.SkeetShooter.Impl;

import com.fallingdutchman.SkeetShooter.Interfaces.GameCore;
import com.fallingdutchman.SkeetShooter.Interfaces.ISkeetMetaDataHandler;
import com.fallingdutchman.SkeetShooter.Listeners.GameEvents;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

/**
 * Created by FallingDutchman on 27-12-15.
 */
public class SkeetShooterCore implements GameCore {

    private static GameCore instance;
    private SkeetShooterCore(){}

    public static GameCore getInstance() {
        if (instance == null) {
            instance = new SkeetShooterCore();
        }

        return instance;
    }

    private Plugin main;

    public void setPlugin(Plugin plugin) {
        main = plugin;
    }

    public Plugin getMainPlugin() {
        return main;
    }

    public void registerEvents() {
        main.getServer().getPluginManager().registerEvents(new GameEvents(), main);
    }

    public void fireProjectile(Player player) {
        if (player.getItemInHand().getType() == Material.WOOD_HOE) {
            Snowball ball = player.getWorld().spawn(player.getLocation(), Snowball.class);
            ball.setShooter(player);
            ball.setVelocity(ball.getVelocity().multiply(3));
        }
    }

    public void fireSkeet(Player player) {
        World world = player.getWorld();
        Location loc = new Location(world, player.getLocation().getBlockX() + 10, player.getLocation().getBlockY(),
                player.getLocation().getBlockZ());

        Pig skeet = world.spawn(loc, Pig.class);
        skeet.setAdult();
        skeet.setVelocity(new Vector(loc.getBlockX() - 20, player.getLocation().getBlockY() + 10, loc.getBlockZ() + 20));

        this.getSkeetMetaDataHandler().applyMetaData(skeet, player);
    }

    public void skeetHit(Player player, Pig skeet, Location location) {
        FireworkEffect fireworkEffect = FireworkEffect.builder()
                .trail(false)
                .withColor(Color.RED)
                .flicker(false)
                .with(FireworkEffect.Type.BALL_LARGE)
                .build();

        Firework firework = (Firework) player.getWorld().spawnEntity(location, EntityType.FIREWORK);
        firework.getFireworkMeta().addEffect(fireworkEffect);

        player.sendMessage("you got him!");
        skeet.remove();
        firework.detonate();
    }

    public ISkeetMetaDataHandler getSkeetMetaDataHandler() {
        return DefaultSkeetMdHandler.getInstance();
    }
}
