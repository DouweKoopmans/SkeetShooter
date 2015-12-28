package com.fallingdutchman.SkeetShooter.Interfaces;

import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;

/**
 * Created by Douwe Koopmans on 28-12-15.
 */
public interface ISkeetMetaDataHandler {
    boolean testSkeetMetaData(Pig skeet, Player player);

    String getSkeetMetadataKey();

    void applyMetaData(Pig skeet, Player player);
}
