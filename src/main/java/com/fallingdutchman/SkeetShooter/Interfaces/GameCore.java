package com.fallingdutchman.SkeetShooter.Interfaces;

import org.bukkit.Location;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created by Douwe Koopmans on 27-12-15.
 */
public interface GameCore {

    /**
     * return the plugin instance
     * @return the plugin instance
     */
    Plugin getMainPlugin();

    /**
     * sets the base plugin class, used for things like registering listeners
     * @param plugin main plugin class
     */
    void setPlugin(Plugin plugin);

    /**
     * register all events for on the server
     */
    void registerEvents();

    /**
     * fire a projectile
     * @param player the shooter
     */
    void fireProjectile(Player player);

    /**
     * fire a skeet
     * @param player location of the player that shoots
     */
    void fireSkeet(Player player);

    /**
     * handle a skeet getting hit
     * @param player
     * @param skeet
     * @param location
     */
    void skeetHit(Player player, Pig skeet, Location location);

    /**
     * returns the skeet metadata handler used by this implementation
     */
    ISkeetMetaDataHandler getSkeetMetaDataHandler();
}
