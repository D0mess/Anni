package me.D0mes.Annihilation.GameManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Locations {
	
	public static void setLocation(String part, Location loc, boolean direction) 
	{
		
		File file = new File("plugins/Annihilation", "locations.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(part + ".world", loc.getWorld().getName());
		cfg.set(part + ".x", Double.valueOf(loc.getX()));
		cfg.set(part + ".y", Double.valueOf(loc.getY()));
		cfg.set(part + ".z", Double.valueOf(loc.getZ()));
		
		if (direction)
		{
		   cfg.set(part + ".yaw", Float.valueOf(loc.getYaw()));
		   cfg.set(part + ".pitch", Float.valueOf(loc.getPitch()));
		}
		try
		{
			cfg.save(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
	}
	
	public static Location getLocation(String part, boolean direction)
	{
		Location loc = null;
		
		File file = new File("plugins/Annihilation", "location.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if (cfg.contains(part))
		{
			String w = cfg.getString(part + ".world");
			double x = cfg.getDouble(part + ".x");
			double y = cfg.getDouble(part + ".y");
			double z = cfg.getDouble(part + ".z");
			double yaw = 0.0D;
			double pitch = 0.0D;
			
			if (cfg.contains(part + ".yaw"))
			{
				yaw = cfg.getDouble(part + ".yaw");
				pitch = cfg.getDouble(part + ".pitch");
			}
			loc = new Location(Bukkit.getWorld(w), x, y, z);
			
			if (direction)
			{
				loc.setYaw((float)yaw);
				loc.setPitch((float)pitch);
			}
		}
		else
		{
			return null;
		}
		return loc;
	}

}