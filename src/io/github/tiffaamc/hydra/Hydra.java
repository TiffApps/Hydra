package io.github.tiffaamc.hydra;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.tiffaamc.hydra.Hydra;
import io.github.tiffaamc.hydra.announcer.Announcer;
import io.github.tiffaamc.hydra.command.Say;
import io.github.tiffaamc.hydra.config.Config;

public class Hydra extends JavaPlugin
{
    private static Hydra _hydra;
    
    @Override
    public void onLoad() {
    	_hydra = this;
    	saveDefaultConfig();
    }
    
    @Override
    public void onEnable() {
        Config.Load(getConfig());
        getCommand("hydrasay").setExecutor(new Say());
        Announcer.announce();
    }

    @Override
    public void onDisable() {
    	Bukkit.getScheduler().cancelTasks(this);
    }
    
    public void reload() {
    	Bukkit.getScheduler().cancelTasks(this);
        reloadConfig();
        Config.Load(getConfig());
        Announcer.announce();
    }

    public static Hydra instance() {
    	return _hydra;
    }
}
