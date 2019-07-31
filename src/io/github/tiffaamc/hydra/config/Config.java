package io.github.tiffaamc.hydra.config;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Config
{
    private Config() {}

//    public static String DISCORD_MESSAGE;
//    public static String FORUMS_MESSAGE;
    public static String NO_PERM_MESSAGE;
    public static String PREFIX_GOOD;
    public static String PREFIX_BAD;
    public static List<String> AUTO;

    public static void Load(FileConfiguration config)
    {
//    	DISCORD_MESSAGE = config.getString("Auto.Discord");
//    	FORUMS_MESSAGE = config.getString("Auto.Forums");
    	NO_PERM_MESSAGE = config.getString("Messages.No-Perm");
        PREFIX_GOOD = config.getString("Messages.Prefix-Good");
        PREFIX_BAD = config.getString("Messages.Prefix-Bad");
        AUTO = transList(config.getStringList("Auto"));
    }

	private static List<String> transList(List<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.set(i, trans(list.get(i)));
        }
        return list;
    }

    private static String trans(String input)
    {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
