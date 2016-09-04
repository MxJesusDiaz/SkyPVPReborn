package mx.jesus.skypvp.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static void CheckFiles() {
		
		File o1 = new File("plugins/SkyPVP-Reborn");
		if(!(o1.exists())){
			o1.mkdir();
		}
		
		File o2 = new File("plugins/SkyPVP-Reborn/players");
			if(!(o2.exists())){
				o2.mkdir();
			}
		
		
		File f1 = new File("plugins/SkyPVP-Reborn/motd.yml");
		if(!(f1.exists())){
			try {
				f1.createNewFile();
				
				YamlConfiguration cfg = new YamlConfiguration();
				
				cfg.set("line1", "§a§lSkyPvP §8 | §2§LREBORN.");
				cfg.set("line2", " §7>> §bYisus is the fucking amo.");
				cfg.set("fakeslots", 10);
				
				cfg.save(f1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		}
	
	public static void loadFiles(){
		File f1 = new File("plugins/SkyPVP-Reborn/motd.yml");
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f1);
		
		BackEnd.motdLine1 = cfg.getString("line1");
		BackEnd.motdLine2 = cfg.getString("line2");
		BackEnd.fakeSlots = cfg.getInt("fakeslots");
	}
	
	public static boolean playerExists(String uuid){
		File  f = new File("plugins/SkyPVP-Reborn/players/" + uuid + ".yml");
		
		return f.exists();
	}
	
	public static void createPlayer(String uuid){
		File f = new File("plugins/SkyPVP-Reborn/players/" + uuid + ".yml");
		
		try {
			f.createNewFile();
			
			YamlConfiguration cfg = new YamlConfiguration();
			
			cfg.set("kills", 0);
			cfg.set("deaths", 0);
			cfg.set("killstreak", 0);
			cfg.set("money", 0);
			
			cfg.save(f);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static SkyPlayer getStats(String uuid){
		File f = new File("plugins/SkyPVP-Reborn/players/" + uuid + ".yml");
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		return new SkyPlayer(
				cfg.getInt("kills"), 
				cfg.getInt("deaths"), 
				cfg.getInt("killstreak"), 
				cfg.getInt("money")); 
				
	}
	
	}


