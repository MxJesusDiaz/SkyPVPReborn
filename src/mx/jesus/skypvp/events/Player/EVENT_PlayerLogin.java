package mx.jesus.skypvp.events.Player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import mx.jesus.skypvp.utils.Strings;
public class EVENT_PlayerLogin implements Listener {

	
	@EventHandler
	public void onPLayerLogin(PlayerLoginEvent e){
		if(e.getResult() == Result.KICK_WHITELIST){
			e.setKickMessage(Strings.prefix.trim() + "\n §fYou not are in the white-list please contact with the Server Administrator." );
		}
	}

	public void OnPlayerJoin(PlayerJoinEvent e){
	    e.setJoinMessage(null);
        Player p = e.getPlayer();

        p.sendMessage(ChatColor.DARK_GREEN.toString() + "Hola Jesus que tal la llevas");
    }
	
}