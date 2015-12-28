package com.fallingdutchman.SkeetShooter;

import com.fallingdutchman.SkeetShooter.Impl.SkeetShooterCore;
import com.fallingdutchman.SkeetShooter.Interfaces.GameCore;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Douwe Koopmans on 27-12-15.
 */
public class SkeetShooter extends JavaPlugin {

    private static final GameCore CORE = SkeetShooterCore.getInstance();

    @Override
    public void onEnable() {
        CORE.setPlugin(this);
        CORE.registerEvents();
    }

    public static GameCore getCORE() {
        return CORE;
    }
}
