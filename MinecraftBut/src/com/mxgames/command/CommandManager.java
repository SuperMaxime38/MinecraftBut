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
					player.sendMessage("§6§l/mcbut explosion <true/false>");
					player.sendMessage("§6§l/mcbut sandrain <true/false>");
					player.sendMessage("§6§l/mcbut lavafloor <true/false> §4COMING SOON");
					player.sendMessage("§4§lMore Coming Soon");
					return true;
				} else if(args.length == 1) { // 1 ARGUMENT
					switch(args[0])  {
					case "lavafloor":
						player.sendMessage("The command is /mcbut lavafloor true/false"); // /mcbut lavafloor
					return true;
					case "reload":
						player.sendMessage("Reloaded Plugin"); // /mcbut reload
					return true;
					case "sandrain":
						player.sendMessage("The command is /mcbut sandrain true/false"); //mcbut sandrain
					return true;
					case "explosion":
						player.sendMessage("The command is /mcbut explosion true/false"); //mcbut explosion
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
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'The Floor Becomes Lava' vient d'être activé"); // /mcbut lavafloor true
						return true;
						case "false":
							main.getConfig().set("game.lavafloor.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'The Floor Becomes Lava' vient d'être désactivé"); // /mcbut lavafloor false
						return true;
						case "luck":
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.lavafloor.luck"));
						return true;
						case "rayon":
							player.sendMessage("The Rayon Radius is actualy : " + main.getConfig().getInt("game.lavafloor.rayon"));
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
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'SandRain' vient d'être activé"); // /mcbut sandrain true
						return true;
						case "false" :
							main.getConfig().set("game.sandrain.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'SandRain' vient d'être désactivé"); // /mcbut sandrain false
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.sandrain.luck"));
						return true;
						case "rayon" :
							player.sendMessage("The Rayon Radius is actualy : " + main.getConfig().getInt("game.sandrain.rayon"));
						return true;
						case "harder" :
							player.sendMessage("The 'Harder' mode is actualy on : " + main.getConfig().getBoolean("game.sandrain.harder"));
						return true;
						case "hardcore" :
							player.sendMessage("The 'Hardcore' mode is actualy on : " + main.getConfig().getBoolean("game.sandrain.hardcore"));
						return true;
						default:
							player.sendMessage("The command is /mcbut sandrain true/false/luck/rayon/harder/hardcore"); // error
						return true;
						}
					case "explosion" :
						switch(args[1]) {
						case "true" :
							main.getConfig().set("game.explosion.enable", true);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'Explosion' vient d'être activé"); // /mcbut explosion true
						return true;
						case "false" :
							main.getConfig().set("game.sandrain.enable", false);
							main.saveConfig();
							Bukkit.broadcastMessage(ChatColor.GOLD + "L'event 'Explosion' vient d'être désactivé"); // /mcbut explosion false
						return true;
						case "luck" :
							player.sendMessage("The Luck Level is actualy : " + main.getConfig().getInt("game.explosion.luck"));
						return true;
						case "rayon" :
							player.sendMessage("The Rayon Radius is actualy : " + main.getConfig().getInt("game.explosion.rayon"));
						return true;
						case "summon" :
							player.sendMessage("The command is /mcbut explosion summon gravel/stone true/false");
						return true;
						default:
							player.sendMessage("The command is /mcbut explosion true/false/luck/rayon"); // error
						return true;
						}
					}
					
				} else if(args.length == 3) {
					switch(args[0]) {
					case "sandrain" :
						
						
						switch(args[1]) {
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.sandrain.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck est bien passé sur " + luck);
						return true;
						case "rayon" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.sandrain.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Rayon est bien passé sur " + rayon);
						return true;
						case "harder":
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean harder = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.harder", harder);
								main.saveConfig();
								player.sendMessage("Harder est bien passé sur " + harder);
								return true;
							}
						return false;
						case "hardcore":
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean hardcore = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.hardcore", hardcore);
								main.saveConfig(); 
								player.sendMessage("Hardcore est bien passé sur " + hardcore);
								return true;
							}
						return false;
						
						
						case "playertarget" :
							if(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								boolean ptarget = Boolean.parseBoolean(args[2]);
								main.getConfig().set("game.sandrain.playertarget", ptarget);
								main.saveConfig();
								player.sendMessage("PlayerTarget est bien passé sur " + ptarget);
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
							player.sendMessage("Luck est bien passé sur " + luck);
						return true;
						case "rayon" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.explosion.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Rayon est bien passé sur " + rayon);
						return true;
						}
						
						return false;
						
						
					case "lavafloor" :
						
						
						switch(args[1]) {
						case "luck":
							int luck = Integer.parseInt(args[2]);
							main.getConfig().set("game.lavafloor.luck", luck);
							main.saveConfig();
							player.sendMessage("Luck est bien passé sur " + luck);
						return true;
						case "rayon" :
							int rayon = Integer.parseInt(args[2]);
							main.getConfig().set("game.lavafloor.rayon", rayon);
							main.saveConfig();
							player.sendMessage("Rayon est bien passé sur " + rayon);
						return true;
						default:
						return false;
						}
					}
				}
			}
		}
		return false;
	} 
} 
