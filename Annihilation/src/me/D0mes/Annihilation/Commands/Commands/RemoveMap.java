package me.D0mes.Annihilation.Commands.Commands;

import org.bukkit.entity.Player;

import me.D0mes.Annihilation.Commands.SubCommand;
import me.D0mes.Annihilation.MapManager.Map;

public class RemoveMap extends SubCommand {
	
	public void onCommand(Player p, String[] args)
	{
		if ((args.length < 2) && (args.length > 0))
		{
			if (args[0].matches("[a-zA-Z]*"))
			{
		    	Map.NewMap(p, args[0]);
		    	p.sendMessage("Mapa se jmenuje: " + args[0]);
			}
		} else {
			p.sendMessage("Spravny tvar: /anni remove <nazev>");
		}
	}

	public String name()
	{
		return "removemap";
	}

}