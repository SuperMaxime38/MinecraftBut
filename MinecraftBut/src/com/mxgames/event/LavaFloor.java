package com.mxgames.event;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.mxgames.Main;

public class LavaFloor implements Listener{

	private Main main;
	public LavaFloor(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void lavaFloor(PlayerMoveEvent e) {
		if(main.getConfig().getBoolean("game.lavafloor.enable") == true) {
			Player p = e.getPlayer();
			int locX = p.getLocation().getBlockX();
			int locZ = p.getLocation().getBlockZ();
			int rayon = main.getConfig().getInt("game.lavafloor.rayon");
			
			Random rdm = new Random();
			
			int rdmX = rdm.nextInt(rayon*2) - rayon;
			int rdmZ = rdm.nextInt(rayon*2) - rayon;
			int X = locX + rdmX;
			int Z = locZ + rdmZ;
			int locY = p.getWorld().getHighestBlockYAt(X, Z);
			
			int maxluck = main.getConfig().getInt("game.lavafloor.luck");
			int luck = rdm.nextInt(maxluck);
			
			Location loc = new Location(p.getWorld(), X, locY, Z);
			
			switch(luck) {
			case 0:
				loc.getBlock().setType(Material.LAVA);
			break;
			}
		}
	}
	
}
