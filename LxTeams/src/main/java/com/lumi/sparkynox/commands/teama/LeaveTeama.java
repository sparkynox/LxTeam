package com.lumi.sparkynox.commands.teama;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.Utils;
import com.lumi.sparkynox.commands.SubCommand;
import com.lumi.sparkynox.message.MessageManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import java.util.List;

public class LeaveTeama extends SubCommand {

	@Override
	public CommandResponse onCommand(CommandSender sender, String label, String[] args) {

		OfflinePlayer p = Utils.getOfflinePlayer(args[0]);
		if (p == null) {
			return new CommandResponse("noPlayer");
		}

		Team team = Team.getTeam(p);
		if (team == null) {
			return new CommandResponse("admin.inTeam");
		}

		if (team.removePlayer(p)) {
			if (p.isOnline()) {
				MessageManager.sendMessage((CommandSender) p, "admin.leave.notify");
			}
			return new CommandResponse(true, "admin.leave.success");
		}
		return new CommandResponse("admin.cancel");
	}

	@Override
	public String getCommand() {
		return "leave";
	}

	@Override
	public String getNode() {
		return "admin.leave";
	}

	@Override
	public String getHelp() {
		return "Force a player to leave a team";
	}

	@Override
	public String getArguments() {
		return "<player>";
	}

	@Override
	public int getMinimumArguments() {
		return 1;
	}

	@Override
	public int getMaximumArguments() {
		return 1;
	}

	@Override
	public void onTabComplete(List<String> options, CommandSender sender, String label, String[] args) {
		if (args.length == 1) {
			addPlayerStringList(options, args[0]);
		}

	}

}
