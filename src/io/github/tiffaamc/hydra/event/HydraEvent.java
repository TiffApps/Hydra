package io.github.tiffaamc.hydra.event;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import io.github.tiffaamc.hydra.util.ParticleEffect;

public class HydraEvent {
	
	public static void checkEvents(String msg)
	{
		if (msg.contains("What a nice weather to go fishing!"))
			rainEvent();
		else if (msg.contains("Spring cleaning!"))
			cleanEvent();
	}
	
	private static void rainEvent()
	{
		World world = Bukkit.getWorld(Config.WORLD);
		world.setWeatherDuration(895 * 20); // = ~15min
		world.setStorm(true);
		world.setThundering(false);
	}
	
	private static void cleanEvent()
	{
		for (Player player : Bukkit.getOnlinePlayers())
			ParticleEffect.VILLAGER_HAPPY.display(1.0f, 1.0f, 1.0f, 0.03f, 50,
					player.getLocation().add(0.5, 1.0, 0.5), Bukkit.getOnlinePlayers());
	}

}
