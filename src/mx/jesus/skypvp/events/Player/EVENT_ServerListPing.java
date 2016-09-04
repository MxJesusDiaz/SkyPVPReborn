package mx.jesus.skypvp.events.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import mx.jesus.skypvp.utils.BackEnd;

public class EVENT_ServerListPing implements Listener {
	
	@EventHandler
	public void onPing(ServerListPingEvent e){
		e.setMotd(BackEnd.motdLine1 + "\n" + BackEnd.motdLine2);
		e.setMaxPlayers(BackEnd.fakeSlots);
	}

}
