package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DelHome extends TeamSubCommand {

	@Override
	public CommandResponse onCommand(TeamPlayer player, String label, String[] args, Team team) {

		if (team.getTeamHome() == null) {
			return new CommandResponse("delhome.noHome");
		}

		team.deleteTeamHome();

		return new CommandResponse(true, "delhome.success");
	}

	@Override
	public String getCommand() {
		return "delhome";
	}

	@Override
	public String getNode() {
		return "delhome";
	}

	@Override
	public String getHelp() {
		return "Delete your team's home";
	}

	@Override
	public String getArguments() {
		return "";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
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
		return PlayerRank.ADMIN;
	}

}
