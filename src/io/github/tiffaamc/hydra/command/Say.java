package io.github.tiffaamc.hydra.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import io.github.tiffaamc.hydra.Hydra;
import io.github.tiffaamc.hydra.config.Config;
import io.github.tiffaamc.hydra.config.Message;

public class Say implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {

        if (!player.hasPermission("hydra.admin") && !(player instanceof ConsoleCommandSender)) {
        	Message.sendNoPermMsg(player);
        	return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload"))
        {
        	Hydra.instance().reload();
        	Message.sendReloadMsg(player);
        	return true;
        }
        
        if (args.length < 2 || (!args[0].equalsIgnoreCase("good") && !args[0].equalsIgnoreCase("bad"))) {
        	Message.sendUsageMsg(player);
        	return true;
        }
        
        String prefix = null;

        if (args[0].equalsIgnoreCase("good"))
        	prefix = Config.PREFIX_GOOD;
        else
        	prefix = Config.PREFIX_BAD;

        args[0] = "";
        String msg = String.join(" ", args);
        Bukkit.broadcastMessage(Message.trans(prefix + msg));

        return true;
    }

}
