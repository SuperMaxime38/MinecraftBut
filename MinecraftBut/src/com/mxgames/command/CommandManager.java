package com.mxgames.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mxgames.Main;

public class CommandManager implements CommandExecutor {

	private Main main;
	public CommandManager(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(label.equalsIgnoreCase("mcbut")) {
				if(args.length == 0) {
					player.sendMessage("§6§lHelp Page for MinecraftBut :"); //Si un jouer tape juste /mcbut
					player.sendMessage("§6§l/mcbut reload : reload the plugin config.yml:");
					player.sendMessage("§6§l/mcbut version : see the Plugin's version");
					player.sendMessage("§6§l/mcbut explosion <true/false>");
					player.sendMessage("§6§l/mcbut sandrain <true/false>");
					player.sendMessage("§6§l/mcbut lavafloor <true/false>");
					player.sendMessage("§6§l/mcbut apocalypse §4Coming Soon");
					return true;
				} else if(args.length == 1) { // 1 ARGUMENT
					switch(args[0])  {
					case "lavafloor":
						player.sendMessage("The command is /mcbut lavafloor true/false/radius/luck"); // /mcbut lavafloor
					return true;
					case "reload":
						main.reloadConfig();
						player.sendMessage("Reloaded Plugin"); // /mcbut reload
					return true;
					case "version":
						player.sendMessage("MinecraftBut version : " + main.getConfig().getString("version"));
					return true;
					case "sandrain":
						player.sendMessage("The command is /mcbut sandrain true/false/radius/luck"); //mcbut sandrain
					return true;
					case "explosion":
						player.sendMessage("The command is /mcbut explosion true/false/radius/luck"); //mcbut explosion
					return true;
					case "apocalypse":
						player.sendMessage("The command is /mcbut apocalypse true/false/luck"); //mcbut apocalypse
					return true;
					case "rtp":
						player.sendMessage("The command is /mcbut rtp onMove/onCraft/onUse/onDrop/maxX/maxZ/luck"); //mcbut rtp
					return true;
					default:
					return false;
					}
				} else if(args.length == 2) { // 2 ARGUMENTS
					switch(args[0]) {
					case "lavafloor":
						switch(args[1]) {
						case "true":
							main.getConfig().set("game.lavafloor.enable", true);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'The Floor Becomes Lava' has been enabled"); // /mcbut lavafloor true
						return true;
						case "false":
							main.getConfig().set("game.lavafloor.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'The Floor Becomes Lava' has been disabled"); // /mcbut lavafloor false
						return true;
						case "luck":
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.lavafloor.luck"));
						return true;
						case "radius":
							player.sendMessage("The Radius is actualy : " + main.getConfig().getInt("game.lavafloor.rayon"));
						return true;
						default:
							player.sendMessage("The command is /mcbut lavafloor true/false"); // error
						return true;
						}
					case "sandrain" :
						switch(args[1]) {
						case "true" :
							main.getConfig().set("game.sandrain.enable", true);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'SandRain' has been enabled"); // /mcbut sandrain true
						return true;
						case "false" :
							main.getConfig().set("game.sandrain.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'SandRain' has been disabled"); // /mcbut sandrain false
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.sandrain.luck"));
						return true;
						case "radius" :
							player.sendMessage("The Radius is actualy : " + main.getConfig().getInt("game.sandrain.rayon"));
						return true;
						case "harder" :
							player.sendMessage("The 'Harder' mode is actualy on : " + main.getConfig().getBoolean("game.sandrain.harder"));
						return true;
						case "hardcore" :
							player.sendMessage("The 'Hardcore' mode is actualy on : " + main.getConfig().getBoolean("game.sandrain.hardcore"));
						return true;
						default:
							player.sendMessage("The command is /mcbut sandrain true/false/luck/radius/harder/hardcore"); // error
						return true;
						}
					case "explosion" :
						switch(args[1]) {
						case "true" :
							main.getConfig().set("game.explosion.enable", true);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'Explosion' has been enabled"); // /mcbut explosion true
						return true;
						case "false" :
							main.getConfig().set("game.explosion.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'Explosion' has been disabled"); // /mcbut explosion false
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.explosion.luck"));
						return true;
						case "radius" :
							player.sendMessage("The Radius is actualy : " + main.getConfig().getInt("game.explosion.rayon"));
						return true;
						case "summon" :
							player.sendMessage("The command is /mcbut explosion summon gravel/stone true/false");
						return true;
						default:
							player.sendMessage("The command is /mcbut explosion true/false/luck/radius"); // error
						return true;
						}
					case "apocalypse" :
						switch(args[1]) {
						case "true" :
							main.getConfig().set("game.apocalypse.enable", true);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'Apocalypse' has been enabled"); // /mcbut apocalypse true
						return true;
						case "false" :
							main.getConfig().set("game.apocalypse.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "'Apocalypse' has been disabled"); // /mcbut apocalypse false
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.apocalypse.luck"));
						return true;
						}
					break;
					case "rtp" :
						switch(args[1]) {
						case "onMove" :
							Bukkit.broadcastMessage(ChatColor.GOLD + "The command is /mcbut rtp onMove <true/false>"); // /mcbut rtp onMove PAS FINI CMD MANAGERRRRRRRRRR
						return true;
						case "onCraft" :
							Bukkit.broadcastMessage(ChatColor.GOLD + "The command is /mcbut rtp onMove <true/false"); // /mcbut rtp onCraft
						return true;
						case "onUse" :
							Bukkit.broadcastMessage(ChatColor.GOLD + "The command is /mcbut rtp onUse <true/false>"); // /mcbut rtp onUse
						return true;
						case "onDrop" :
							Bukkit.broadcastMessage(ChatColor.GOLD + "The command is /mcbut rtp onDrop <true/false"); // /mcbut rtp onDrop
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.rtp.luck"));
						return true;
						case "maxX" :
							player.sendMessage("The maxX is actualy : " + main.getConfig().getInt("game.rtp.maxX"));
						return true;
						case "maxZ" :
							player.sendMessage("The maxZ is actualy : " + main.getConfig().getInt("game.rtp.maxZ"));
						return true;
						}
					break;
					}
					
				} else if(args.length == 3) {
					switch(args[0]) {
					case "sandrain" :
						
						
						switch(args[1]) {
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.sandrain.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck is now at " + luck);
						return true;
						case "radius" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.sandrain.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Radius is now at " + rayon);
						return true;
						case "harder":
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean harder = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.harder", harder);
								main.saveConfig();
								player.sendMessage("Harder is now at " + harder);
								return true;
							}
						return false;
						case "hardcore":
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean hardcore = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.hardcore", hardcore);
								main.saveConfig(); 
								player.sendMessage("Hardcore is now at " + hardcore);
								return true;
							}
						return false;
						
						
						case "playertarget" :
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean ptarget = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.playertarget", ptarget);
								main.saveConfig();
								player.sendMessage("PlayerTarget is now at " + ptarget);
								return true;
							}
						default:
						return false;
						}
						
						
					case "explosion" :
						
						
						switch(args[1]) {
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.explosion.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck is now at " + luck);
						return true;
						case "radius" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.explosion.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Radius is now at " + rayon);
						return true;
						}
						
						return false;
						
						
					case "lavafloor" :
						
						
						switch(args[1]) {
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.lavafloor.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck is now at " + luck);
						return true;
						case "radius" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.lavafloor.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Radius is now at " + rayon);
						return true;
						default:
						return false;
						}
						
						
					case "apocalypse":
						
						if(args[1].equalsIgnoreCase("luck")) {
							int luck = Integer.parseInt(args[2]);
							if(luck < 30) {
								main.getConfig().set("game.apocalypse.luck", 30);
								main.saveConfig();
								player.sendMessage("§4Minimum luck is 30... Luck set on 30...");
								return true;
							} else {
								main.getConfig().set("game.apocalypse.luck", luck);
								main.saveConfig();
								player.sendMessage("Luck is now at " + luck);
								return true;
							}
						}
					break;
					
					case "rtp":
						boolean rtp = Boolean.parseBoolean(args[2]);
						switch(args[1]) {
						case "onMove" :
							if(args[2].equalsIgnoreCase("true")) {
								main.getConfig().set("game.rtp.enable.onMove", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been enabled when a player move");
							} else if(args[2].equalsIgnoreCase("false")) {
								main.getConfig().set("game.rtp.enable.onMove", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been disabled when a player move");
							} else {
								return false;
							}
						return true;
						case "onCraft" :
							if(args[2].equalsIgnoreCase("true")) {
								main.getConfig().set("game.rtp.enable.onCraft", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been enabled when a player is crafting");
							} else if(args[2].equalsIgnoreCase("false")) {
								main.getConfig().set("game.rtp.enable.onCraft", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been disabled when a player is crafting");
							} else {
								return false;
							}
						return true;
						case "onUse" :
							if(args[2].equalsIgnoreCase("true")) {
								main.getConfig().set("game.rtp.enable.onUse", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been enabled when a player use an item or place a block");
							} else if(args[2].equalsIgnoreCase("false")) {
								main.getConfig().set("game.rtp.enable.onUse", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been disabled when a player use an item or place a block");
							} else {
								return false;
							}
						return true;
						case "onDrop" :
							if(args[2].equalsIgnoreCase("true")) {
								main.getConfig().set("game.rtp.enable.onDrop", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been enabled when a player drop an item");
							} else if(args[2].equalsIgnoreCase("false")) {
								main.getConfig().set("game.rtp.enable.onDrop", rtp);
								main.saveConfig();
								Bukkit.broadcastMessage(ChatColor.GOLD + "'RandomTP' has been disabled when a player drop an item");
							} else {
								return false;
							}
						return true;
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.rtp.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck is now at " + luck);
						return true;
						case "maxX":
							int maxX = Integer.parseInt(args[2]);
							main.getConfig().set("game.rtp.maxX", maxX);
							main.saveConfig();
							player.sendMessage("maxX is now at " + maxX);
						return true;
						case "maxZ":
							int maxZ = Integer.parseInt(args[2]);
							main.getConfig().set("game.rtp.maxZ", maxZ);
							main.saveConfig();
							player.sendMessage("maxZ is now at " + maxZ);
						return true;
						}
						
					break;
					
					
					
					default:
					return false;
					}
				}
			}
		}
		return false;
	} 
} 
