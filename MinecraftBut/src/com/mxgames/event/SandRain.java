package com.mxgames.event;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.mxgames.Main;

public class SandRain implements Listener{

	
	private Main main;
	public SandRain(Main main) {
		this.main = main;
	}

	@EventHandler
	public void Rain(PlayerMoveEvent e) {
		Player p = e.getPlayer();
			if(main.getConfig().getBoolean("game.sandrain.enable") == true) {
				int locX = p.getLocation().getBlockX();
				int locZ = p.getLocation().getBlockZ();
				int rayon = main.getConfig().getInt("game.sandrain.rayon");
				
				Random rdm = new Random();
				
				int rdmX = rdm.nextInt(rayon*2) - rayon;
				int rdmZ = rdm.nextInt(rayon*2) - rayon;
				int X = locX + rdmX;
				int Z = locZ + rdmZ;
				int maxY = p.getWorld().getHighestBlockAt(X, Z).getY();
				int locY = maxY + 10;
				
				int hX = X + rdm.nextInt(8) - rdm.nextInt(4);
				int hZ = Z + rdm.nextInt(8) - rdm.nextInt(4);
				
				int PrdmX = rdm.nextInt(32) - 16;
				int PrdmZ = rdm.nextInt(32) - 16;
				int PX = locX + PrdmX;
				int PZ = locZ + PrdmZ;
				
				int maxluck = main.getConfig().getInt("game.sandrain.luck");
				int luck = rdm.nextInt(maxluck);
				
				Location loc = new Location(p.getWorld(), X, locY, Z);
				Location harder = new Location(p.getWorld(), hX, locY, hZ);
				Location phard = new Location(p.getWorld(), PX, locY, PZ);
				Location hard = new Location(p.getWorld(), locX, locY, locZ);
				
				switch(luck) {
				case 0:
					loc.getBlock().setType(Material.SAND);
					if(main.getConfig().getBoolean("game.sandrain.harder") == true)
						harder.getBlock().setType(Material.SAND);
					if(main.getConfig().getBoolean("game.sandrain.playertarget") == true)
						phard.getBlock().setType(Material.SAND);
				break;
				case 1:
					loc.getBlock().setType(Material.GRAVEL);
					if(main.getConfig().getBoolean("game.sandrain.harder") == true)
						harder.getBlock().setType(Material.GRAVEL);
					if(main.getConfig().getBoolean("game.sandrain.playertarget") == true)
						phard.getBlock().setType(Material.GRAVEL);
				break;
				case 2:
					loc.getBlock().setType(Material.SAND);
					if(main.getConfig().getBoolean("game.sandrain.hardcore") == true)
					hard.getBlock().setType(Material.SAND);
				break;
				case 3:
					loc.getBlock().setType(Material.GRAVEL);
					if(main.getConfig().getBoolean("game.sandrain.hardcore") == true)
					hard.getBlock().setType(Material.GRAVEL);
				break;
				default:
				break;
				}
				
			}
	}
	
}
