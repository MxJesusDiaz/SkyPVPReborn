package mx.jesus.skypvp.events.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
	
	
}
