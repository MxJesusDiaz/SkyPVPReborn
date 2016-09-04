package mx.jesus.skypvp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import mx.jesus.skypvp.commands.COMMAND_DeOperator;
import mx.jesus.skypvp.commands.COMMAND_Operator;
import mx.jesus.skypvp.events.Player.EVENT_PlayerJoin;
import mx.jesus.skypvp.events.Player.EVENT_PlayerLogin;
import mx.jesus.skypvp.events.Player.EVENT_ServerListPing;

public class PluginManager {
	
	public static void load(){
		
		registerEvents();
		registerCommands();
	}

	private static void registerEvents(){
		
		org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
		Plugin pl = Main.instance;
		
		pm.registerEvents(new EVENT_PlayerJoin(), pl);
		pm.registerEvents(new EVENT_PlayerLogin(), pl);
		pm.registerEvents(new EVENT_ServerListPing(), pl);
	}
	
	private static void registerCommands(){
		
		Bukkit.getPluginCommand("op").setExecutor(new COMMAND_Operator());
		Bukkit.getPluginCommand("deop").setExecutor(new COMMAND_DeOperator());
	}
	
}
