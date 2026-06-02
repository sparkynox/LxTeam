package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import com.lumi.sparkynox.message.MessageManager;
import com.lumi.sparkynox.message.ReferencedFormatMessage;
import com.lumi.sparkynox.util.TeamUtil;
import org.bukkit.command.CommandSender;

import java.util.List;

public class NameCommand extends TeamSubCommand {

	public NameCommand() {
		checkRank = false;
	}

	@Override
	public CommandResponse onCommand(TeamPlayer teamPlayer, String label, String[] args, Team team) {

		if (args.length == 0) {
			return new CommandResponse(new ReferencedFormatMessage("name.view", team.getName()));
		}

		if (teamPlayer.getRank().value < getRequiredRank().value) {
			MessageManager.sendMessage(teamPlayer.getPlayer().getPlayer(), "name.view", team.getName());
			return new CommandResponse("name.noPerm");
		}

		CommandResponse response = TeamUtil.verifyTeamName(args[0]);
		if (response != null) {
			return response;
		}

		if (Team.getTeamManager().isTeam(args[0])) {
			return new CommandResponse("name.exists");
		}

		team.setName(args[0], teamPlayer.getPlayer().getPlayer());

		return new CommandResponse(true, "name.success");
	}

	@Override
	public String getCommand() {
		return "name";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public String getNode() {
		return "name";
	}

	@Override
	public String getHelp() {
		return "View and change your team's name";
	}

	@Override
	public String getArguments() {
		return "<name>";
	}

	@Override
	public int getMaximumArguments() {
		return 1;
	}

	@Override
	public void onTabComplete(List<String> options, CommandSender sender, String label, String[] args) {
		options.add("<name>");
	}

	@Override
	public PlayerRank getDefaultRank() {
		return PlayerRank.OWNER;
	}

}
