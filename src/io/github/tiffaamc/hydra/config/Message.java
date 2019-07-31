package io.github.tiffaamc.hydra.config;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import io.github.tiffaamc.hydra.config.Config;

public class Message {

	public static void sendReloadMsg(CommandSender player) {
        String prefix = Config.PREFIX_GOOD;
        String msg = "Neat, I have reloaded my own configuration!";
        player.sendMessage(trans(prefix + msg));
    }

	public static void sendNoPermMsg(CommandSender player) {
		String prefix = Config.PREFIX_BAD;
		String msg = Config.NO_PERM_MESSAGE;
        player.sendMessage(trans(prefix + msg));
	}
	
	public static List<String> transList(List<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.set(i, trans(list.get(i)));
        }
        return list;
    }

	public static String trans(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}

	public static void sendUsageMsg(CommandSender player) {
		String prefix = Config.PREFIX_BAD;
        String msg = "Incorrect parameters. Usage: /hsay <good/bad> <message>";
        player.sendMessage(trans(prefix + msg));
	}

}
