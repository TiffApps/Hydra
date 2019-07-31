package io.github.tiffaamc.hydra.announcer;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import io.github.tiffaamc.hydra.Hydra;
import io.github.tiffaamc.hydra.config.Config;
import io.github.tiffaamc.hydra.config.Message;
import io.github.tiffaamc.hydra.event.HydraEvent;

public class Announcer {
	
	public static void announce() {
		FileConfiguration config = Hydra.instance().getConfig();

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Hydra.instance(), () -> {

			Bukkit.broadcastMessage(getAnnouncement(config));

		}, 0, config.getInt("seconds") * 20);
	}

	private static String getAnnouncement(FileConfiguration config) {
		List<String> list = config.getStringList("Announcement");
		Random r = new Random();
		String msg = list.get(r.nextInt(list.size()));
		String prefix = "";
		if (msg.contains("{G}")) {
			prefix = Config.PREFIX_GOOD;
			msg = msg.replace("{G}", prefix);
		} else {
			prefix = Config.PREFIX_BAD;
			msg = msg.replace("{B}", prefix);
		}
		HydraEvent.checkEvents(msg);
		return Message.trans(msg);
	}

}
