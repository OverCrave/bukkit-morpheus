package net.overcrave.morpheus.command;

import net.overcrave.morpheus.main.Morpheus;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class MorpheusCommand implements CommandExecutor, TabCompleter
{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) 
	{
		if(args.length <= 1)
		{
			List<String> argList = new ArrayList<>();
			argList.add("toggle");
			return argList;
		}
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(!sender.hasPermission("morpheus.toggle"))
		{
			sender.sendMessage(Morpheus.customConfig.getString("messages.no-permission"));
			return true;
		}
		else if(args.length > 0 && args[0].toLowerCase() == "toggle")
		{
			Morpheus.toggled = !Morpheus.toggled;
			return true;
		}
		else
		{
			sender.sendMessage(Morpheus.customConfig.getString("messages.default"));
			return false;
		}
	}
	
}
