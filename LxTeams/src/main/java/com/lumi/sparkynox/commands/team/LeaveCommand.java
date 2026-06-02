package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * This class handles the /team leave command
 *
 * @author SparkyNox
 */
public class LeaveCommand extends TeamSubCommand {

	@Override
	public CommandResponse onCommand(TeamPlayer teamPlayer, String label, String[] args, Team team) {

		if (teamPlayer.getRank() == PlayerRank.OWNER && team.getRank(PlayerRank.OWNER).size() == 1) {
			return new CommandResponse("leave.lastOwner");
		}

		if (team.removePlayer(teamPlayer.getPlayer())) {
			return new CommandResponse(true, "leave.success");
		}
		// event has been cancelled
		return new CommandResponse(false);
	}

	@Override
	public String getCommand() {
		return "leave";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public String getNode() {
		return "leave";
	}

	@Override
	public String getHelp() {
		return "Leave your current team";
	}

	@Override
	public String getArguments() {
		return "";
	}

	@Override
	public int getMaximumArguments() {
		return 0;
	}

	@Override
	public void onTabComplete(List<String> options, CommandSender sender, String label, String[] args) {

	}

	@Override
	public PlayerRank getDefaultRank() {
		return PlayerRank.DEFAULT;
	}

}
