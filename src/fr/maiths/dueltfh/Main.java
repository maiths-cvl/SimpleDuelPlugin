package fr.maiths.dueltfh;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.maiths.dueltfh.commands.Duel;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("SimpleDuels has been enabled with succes");
		
		getCommand("duel").setExecutor((CommandExecutor) new Duel());
	}
	
	@Override
	public void onDisable() {
		getLogger().info("SimpleDuels has been enabled with succes");
	}
	
	

}
