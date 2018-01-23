package me.D0mes.Annihilation.Commands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	
	public String usage = "Invalid command: /anni";
	
	public abstract void onCommand(Player paramPlayer, String[] paramArrayOfString);

	public abstract String name();
	
	
}
