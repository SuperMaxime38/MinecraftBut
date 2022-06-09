package com.mxgames.event;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mxgames.Main;

public class Apocalypse implements Listener{

	private Main main;
	public Apocalypse(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void apolcalypse(PlayerMoveEvent e) {
		if(main.getConfig().getBoolean("game.apocalypse.enable") == true) {
			Player p = e.getPlayer();
			Location ploc = p.getLocation();
			Location loc10Y = p.getLocation().add(0, 10, 0);
			int inv = p.getInventory().getSize();
			if(loc10Y.getBlock().getType() != (Material.AIR)) {
				loc10Y = ploc;
			}
			
			int maxluck = main.getConfig().getInt("game.apocalypse.luck");
			if(maxluck < 80) maxluck = 80;
			
			Random rdm = new Random();
			int luck = rdm.nextInt(maxluck);
			
			switch(luck) {
			case 0:
				loc10Y.getBlock().setType(Material.ANVIL);
			break;
			case 1:
				p.getWorld().spawnEntity(loc10Y, EntityType.ZOMBIE);
			break;
			case 2:
				p.getInventory().addItem(new ItemStack(Material.DIAMOND));
			break;
			case 3:
				for(int i = 0; i < 8; i++) {
					p.getWorld().spawnEntity(ploc, EntityType.CREEPER);
				}
			break;
			case 4:
				ploc.getBlock().setType(Material.LAVA);
			break;
			case 5:
				for(int i = 0; i < inv; i++) {
					ItemStack item = new ItemStack(Material.POTATO);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§6§lTrolled");
					item.setItemMeta(meta);
					
					p.getInventory().setItem(i, item);
				}
			case 6:
				int X = p.getLocation().getBlockX() + new Random().nextInt(2000) - 1000;
				int Z = p.getLocation().getBlockZ() + new Random().nextInt(2000) - 1000;
				int Y = p.getWorld().getHighestBlockAt(X, Z).getY() + 1;
				Location rtp = new Location(p.getWorld(), X, Y, Z);
				p.teleport(rtp);
			break;
			case 7:
				int rInv = rdm.nextInt(inv);
				p.getInventory().setItem(rInv, new ItemStack(Material.AIR));
				p.sendMessage("" + luck);
			break;
			default:
			break;
			}
		}
	}
	
}
