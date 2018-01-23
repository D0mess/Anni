package me.D0mes.Annihilation.MapManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Map {
	
	static File file = new File("plugins/Annihilation", "maps.yml");
	static FileConfiguration maps = YamlConfiguration.loadConfiguration(file);
	
	public static void NewMap(Player p, String name)
	{
		if (maps.get(name) != name)
		{
		maps.set(name + ".world", "hovno");
	    try
	    {
	      maps.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
		} else {
			p.sendMessage("Mapa existuje");
		}
	  }
	
	public static void RemoveMap(int ID)
	{		
		maps.set(ID + "", null);
	    try
	    {
	      maps.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	
	
	public static boolean ExistMap(int ID)
	{
		if (maps.getInt("", ID) == ID)
		{
			return true;
		} else {
			
		return false;
		}
	}

}
