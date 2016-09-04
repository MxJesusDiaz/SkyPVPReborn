package mx.jesus.skypvp;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import mx.jesus.skypvp.utils.ConfigManager;

public class Main extends JavaPlugin {
	
	public static Plugin instance;
	
	public void onEnable(){
		Main.instance = this;
		
		ConfigManager.CheckFiles();
		ConfigManager.loadFiles();
		
		PluginManager.load();
	}

}
