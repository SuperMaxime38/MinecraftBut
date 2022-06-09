package com.mxgames.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCommand implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		
			if(args.length == 1) {
				List<String> arg0 = new ArrayList<>();
				
				arg0.add("sandrain");
				arg0.add("explosion");
				arg0.add("lavafloor");
				arg0.add("apocalypse");
				arg0.add("rtp");
				arg0.add("reload");
				arg0.add("version");
				
				return arg0;
			} else if(args.length == 2) {
				List<String> arg1 = new ArrayList<>();
				
				switch(args[0]) {
				case "explosion" :
					arg1.add("true");
					arg1.add("false");
					arg1.add("radius");
					arg1.add("luck");
					//arg1.add("summon");
				break;
				case "sandrain" :
					arg1.add("true");
					arg1.add("false");
					arg1.add("radius");
					arg1.add("luck");
					arg1.add("harder");
					arg1.add("hardcore");
					arg1.add("playertarget");
				break;
				case "lavafloor" :
					arg1.add("true");
					arg1.add("false");
					arg1.add("radius");
					arg1.add("luck");
				break;
				case "apocalypse" :
					arg1.add("true");
					arg1.add("false");
					arg1.add("luck");
				break;
				case "rtp" :
					arg1.add("onMove");
					arg1.add("onCraft");
					arg1.add("onUse");
					arg1.add("onDrop");
					arg1.add("maxX");
					arg1.add("maxZ");
					arg1.add("luck");
				break;
				}
				
				
				return arg1;
			} else if(args.length == 3) {
				List<String> arg = new ArrayList<>();
				
				switch(args[0]) {
				case "explosion" :
					switch(args[1]) {
					case "summon" :
						arg.add("gravel true");
						arg.add("gravel false");
						arg.add("stone true");
						arg.add("stone false");
					break;
					}
				break;
				case "rtp":
					switch(args[1]) {
					case "onMove" :
						arg.add("true");
						arg.add("false");
					break;
					case "onCraft" :
						arg.add("true");
						arg.add("false");
					break;
					case "onUse" :
						arg.add("true");
						arg.add("false");
					break;
					case "onDrop" :
						arg.add("true");
						arg.add("false");
					break;
					}
				break;
				}
				return arg;
			}
		return null;
	}

}
