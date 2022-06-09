package com.mxgames;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.mxgames.command.CommandManager;
import com.mxgames.command.TabCommand;
import com.mxgames.event.Apocalypse;
import com.mxgames.event.Explosion;
import com.mxgames.event.LavaFloor;
import com.mxgames.event.RandomTP;
import com.mxgames.event.SandRain;

public class Main extends JavaPlugin{
	
	FileConfiguration config;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		config = getConfig();
		getCommand("mcbut").setExecutor(new CommandManager(this));
		getCommand("mcbut").setTabCompleter(new TabCommand());
		getServer().getPluginManager().registerEvents(new Explosion(this), this);
		getServer().getPluginManager().registerEvents(new SandRain(this), this);
		getServer().getPluginManager().registerEvents(new LavaFloor(this), this);
		getServer().getPluginManager().registerEvents(new Apocalypse(this), this);
		getServer().getPluginManager().registerEvents(new RandomTP(this), this);
		System.out.println("[MinecraftBut] Plugin started");
		System.out.println("[MinecraftBut] Warning: This plugin may cause lag on your server");
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin stoped");
	}
	
}
