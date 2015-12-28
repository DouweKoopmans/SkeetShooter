package com.fallingdutchman.SkeetShooter.Impl;

import com.fallingdutchman.SkeetShooter.SkeetShooter;
import com.fallingdutchman.SkeetShooter.Interfaces.ISkeetMetaDataHandler;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

/**
 * Created by FallingDutchman on 28-12-15.
 */
public class DefaultSkeetMdHandler implements ISkeetMetaDataHandler {
    private static ISkeetMetaDataHandler metaDataHandler;
    private DefaultSkeetMdHandler() {
    }

    public static ISkeetMetaDataHandler getInstance() {
        if (metaDataHandler == null) {
            metaDataHandler = new DefaultSkeetMdHandler();
        }

        return metaDataHandler;
    }

    public boolean testSkeetMetaData(Pig skeet, Player player) {
        for (MetadataValue value : skeet.getMetadata(getSkeetMetadataKey())) {
            if (value.asString().equals(player.getName())) {
                return true;
            }
        }

        return false;
    }

    public String getSkeetMetadataKey() {
        return "SkeetShooter";
    }

    public void applyMetaData(Pig skeet, Player player) {
        skeet.setMetadata(getSkeetMetadataKey(), new FixedMetadataValue(SkeetShooter.getCORE().getMainPlugin(),
                player.getName()));
    }
}
