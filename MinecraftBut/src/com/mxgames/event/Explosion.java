package com.mxgames.event;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import com.mxgames.Main;

public class Explosion implements Listener {

	private Main main;
	
	public Explosion(Main main) {
		this.main = main;
	}
	

	@EventHandler
	public void enterChunk(PlayerMoveEvent event) {
		if(main.getConfig().getBoolean("game.explosion.enable") == true) {
			
			Player p = event.getPlayer();
			int locX = p.getLocation().getBlockX();
			int locZ = p.getLocation().getBlockZ();
			int maxY = p.getWorld().getHighestBlockAt(locX, locZ).getY();
			
			Random rdm = new Random();
			
			int locY = rdm.nextInt(maxY);
			if(locY < 5) locY = 5;
			
			int maxluck = main.getConfig().getInt("game.explosion.luck");
			int luck = rdm.nextInt(maxluck);
			//p.sendMessage("" + luck);
		
			int rayon = main.getConfig().getInt("game.explosion.rayon");
			int rdmX = rdm.nextInt(rayon*2) - rayon;
			int rdmZ = rdm.nextInt(rayon*2) - rayon;
			
			int X = locX + rdmX;
			int Z = locZ + rdmZ;
		
			Location loc = new Location(p.getWorld(), X, locY, Z);
			Location bled = new Location(p.getWorld(), X + 1, locY, Z);
			
			
			
			switch(luck) {
			case 0:
				loc.getBlock().setType(Material.TNT);
				bled.getBlock().setType(Material.REDSTONE_BLOCK);
				bled.getBlock().setType(Material.AIR);
			break;
			case 1:
				if(main.getConfig().getBoolean("game.explosion.summon.gravel") == true) {
					loc.getBlock().setType(Material.GRAVEL);
				}
			break;
			case 2:
				if(main.getConfig().getBoolean("game.explosion.summon.gravel") == true) {
					loc.getBlock().setType(Material.STONE);
				}
			default:
			break;
			}
		}
	}

}