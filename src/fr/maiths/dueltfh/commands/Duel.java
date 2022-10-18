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
			if (args.length > 0) {
				if (Bukkit.getServer().getPlayer(args[0]) != null && Bukkit.getServer().getPlayer(args[0]).getName().equalsIgnoreCase(args[0])) {
					player.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.WHITE + " is online !!");
					
					TextComponent message = new TextComponent("Click me");
					message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org"));
					message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Visit the Spigot website!").create()));
					message.addWith("Maiths");
					
				} else {
					player.sendMessage(ChatColor.RED + "This player is offline");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Error witht the syntax, try : /duel {playername}");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You are not a player");
		}
		return false;
	}

}
