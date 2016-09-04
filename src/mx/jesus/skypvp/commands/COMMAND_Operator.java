package mx.jesus.skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mx.jesus.skypvp.utils.Strings;

public class COMMAND_Operator implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Strings.onlyPlayer);
			return true;
		}

		Player p = (Player)sender;
		
		if(p.hasPermission("skypvp.op")){
			if(args.length == 0){
				p.setOp(true);
				p.sendMessage(Strings.optSelf);
			} else {
				@SuppressWarnings("deprecation")
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				
					op.setOp(true);
					p.sendMessage(Strings.opOther.replace("[0]", op.getName()));
				}
			
			
		} else {
			
			p.sendMessage(Strings.noPermissions);
			
		}
		return true;
	}
}


