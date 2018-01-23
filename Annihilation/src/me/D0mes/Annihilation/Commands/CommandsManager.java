package me.D0mes.Annihilation.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.D0mes.Annihilation.Commands.Commands.CreateMap;

public class CommandsManager implements CommandExecutor {
	
	private ArrayList<SubCommand> commands = new ArrayList();

	public void setup()
	{
		this.commands.add(new CreateMap());
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (!(sender instanceof Player))
		{
			sender.sendMessage("This command can use only ingame");
			return true;
		}
		
		Player p = (Player)sender;
		if (label.equalsIgnoreCase("anni"))
		{
			if (args.length == 0)
			{
				p.sendMessage("cmd");
				return true;
			}
			SubCommand target = get(args[0]);
			if (target == null)
			{
				p.sendMessage(args[0] + "is not valid command");
				return true;
			}
			ArrayList<String> a = new ArrayList();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = (String[])a.toArray(new String[a.size()]);
			try
			{
				target.onCommand(p, args);
			}
			catch (Exception e)
			{
				p.sendMessage("Error: " + e.getCause());
				e.printStackTrace();
			}
		}
				return true;
	}
	
	private SubCommand get(String name)
	{
		for (SubCommand cmd : this.commands)
		{
			if (cmd.name().equalsIgnoreCase(name))
			{
				return cmd;
			}
		}
		return null;
	}
	

}
