package mx.jesus.skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mx.jesus.skypvp.utils.Strings;

public class COMMAND_DeOperator implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Strings.onlyPlayer);
			return true;
		}

		Player p = (Player)sender;
		if(p.hasPermission("skypvp.deop")){
			if(args.length == 0){
				if(p.isOp()){
					p.setOp(false);
					p.sendMessage(Strings.deoptSelf);
				} else {
					p.sendMessage(Strings.noOperator);
					
				}
			} else {
				@SuppressWarnings("deprecation")
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				
				if(op.isOp()){
					op.setOp(false);
					p.sendMessage(Strings.deopOther.replace("[0]", op.getName()));
				} else {
					p.sendMessage(Strings.otherNoOperator.replace("[0]", op.getName()));
				}
				
			}
			
			
		} else {
			
			p.sendMessage(Strings.noPermissions);
			
		}
		return true;
	}

}
