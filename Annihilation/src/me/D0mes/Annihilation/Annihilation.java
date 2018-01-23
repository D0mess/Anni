package me.D0mes.Annihilation;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.D0mes.Annihilation.Commands.CommandsManager;
import me.D0mes.Annihilation.Events.Join;

public class Annihilation extends JavaPlugin implements Listener {
	
	public static Plugin annihilation;
	public static Annihilation anni;
	
	public void onEnable() {
		
		anni = this;
		
		getServer().getPluginManager().registerEvents(new Join(), this);
		
		CommandsManager cm = new CommandsManager();
		cm.setup();
		getCommand("anni").setExecutor(cm);
		
		saveDefaultConfig();
		
	}
	
	public void onDisable() {
		
	}
	
	public static Plugin getPlugin() {
		
		return Bukkit.getServer().getPluginManager().getPlugin("Annihilation+");
	
	}
	
	public static Annihilation getInstance() {
		
		return anni;
		
	}
	
	
}
