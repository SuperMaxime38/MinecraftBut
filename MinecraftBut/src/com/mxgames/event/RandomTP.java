package com.mxgames.event;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import com.mxgames.Main;

public class RandomTP implements Listener{

	private Main main;
	public RandomTP(Main main) {
		this.main = main;
	}
	
	int maxX;
	int maxZ;
	int maxluck;
	int luck;
	int X;
	int Y;
	int Z;
	Player p;
	Random rdm;
	//int random;
	
	public void test() {
		maxX = main.getConfig().getInt("game.rtp.coord.maxX");
		maxZ = main.getConfig().getInt("game.rtp.coord.maxZ");
		maxluck = main.getConfig().getInt("game.rtp.luck");
		rdm = new Random();
	}
	
	public void setRandom() {
		X = X + rdm.nextInt(maxX*2) - maxX;
		Z = Z + rdm.nextInt(maxZ*2) - maxX;
		luck = rdm.nextInt(maxluck);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(main.getConfig().getBoolean("game.rtp.enable.onMove") == true) { //MARCHE
			test();
			setRandom();
			p = e.getPlayer();
			
			switch(luck) {
			case 0:
				System.out.println("Move");
				Y = p.getWorld().getHighestBlockAt(X, Z).getY() + 2;
				Location rtp = new Location(p.getWorld(), X, Y, Z, 0.0f, 0.0f);
				p.teleport(rtp);
			break;
			default:
			break;
			}
		}
	}
	
	
	@EventHandler 
	public void onCraft(CraftItemEvent e) {
		if(main.getConfig().getBoolean("game.rtp.enable.onCraft") == true) { //MARCHE PAS !
			test();
			setRandom();
			if(e.getWhoClicked() instanceof Player) p = (Player) e.getWhoClicked();
			
			switch(luck) {
			case 0:
				System.out.println("Craft");
				Y = p.getWorld().getHighestBlockAt(X, Z).getY() + 2;
				Location rtp = new Location(p.getWorld(), X, Y, Z, 0.0f, 0.0f);
				p.teleport(rtp);
			break;
			default:
			break;
			}
		}
	}
	
	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		if(main.getConfig().getBoolean("game.rtp.enable.onUse") == true) { //MARCHE
			test();
			setRandom();
			p = e.getPlayer();
			
			switch(luck) {
			case 0:
				System.out.println("use");
				Y = p.getWorld().getHighestBlockAt(X, Z).getY() + 2;
				Location rtp = new Location(p.getWorld(), X, Y, Z, 0.0f, 0.0f);
				p.teleport(rtp);
			break;
			default:
			break;
			}
		}
	}
	
	 @EventHandler
	 public void onDrop(PlayerDropItemEvent e) {
		 if(main.getConfig().getBoolean("game.rtp.enable.onDrop") == true) { //MARCHE
			 test();
				setRandom();
				p = e.getPlayer();
				
				switch(luck) {
				case 0:
					System.out.println("Drop");
					Y = p.getWorld().getHighestBlockAt(X, Z).getY() + 2;
					Location rtp = new Location(p.getWorld(), X, Y, Z, 0.0f, 0.0f);
					p.teleport(rtp);
				break;
				default:
				break;
				}
			}
	 }
}
