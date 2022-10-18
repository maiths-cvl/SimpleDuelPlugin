package fr.maiths.dueltfh.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Duel implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			//if (player.hasPermission("duel.send")) {
				if (args.length > 0) {
					if (Bukkit.getServer().getPlayer(args[0]) != null && Bukkit.getServer().getPlayer(args[0]).getName().equalsIgnoreCase(args[0])) {
						player.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.WHITE + " is online !!");
						
						TextComponent message = new TextComponent("You can click here");
						message.setColor(ChatColor.GOLD);
						message.setBold(true);
						message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/say hi")); // problem to run tp command as an op without having perms
						message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
								new ComponentBuilder("Opens you hypixel's jobs page").color(ChatColor.YELLOW).create()));
						player.spigot().sendMessage(message);
						
					} else {
						player.sendMessage(ChatColor.RED + "This player is offline");
					}
				} else {
					player.sendMessage(ChatColor.RED + "Error witht the syntax, try : /duel {playername}");
				}
			/*} else {
				player.sendMessage(ChatColor.RED + "You don't have the permission to run this command");
			}*/
			
		} else {
			sender.sendMessage(ChatColor.RED + "You are not a player");
		}
		return false;
	}

}

/*
TextComponent message = new TextComponent("You can click here");
message.setColor(ChatColor.GOLD);
message.setBold(true);
message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.hypixel.net/jobs"));
message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
		new ComponentBuilder("Opens you hypixel's jobs page").color(ChatColor.YELLOW).create()));
player.spigot().sendMessage(message);*/
