package mx.jesus.skypvp.events.Player;


import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class EVENT_PlayerJoin implements Listener {
	ArrayList<Player> Saludos = new ArrayList<Player> ();	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onJoin(PlayerJoinEvent e){
		
		
		Saludos.add(e.getPlayer());
		Saludos.add(0, e.getPlayer());

		


		if(Saludos.contains(e.getPlayer())){
			e.setJoinMessage(null);
			e.getPlayer().sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "¡Bienvenido a Minplay! " + ChatColor.WHITE.toString() + ChatColor.BOLD + e.getPlayer().getName());
			
		}
		

		
	}

}
