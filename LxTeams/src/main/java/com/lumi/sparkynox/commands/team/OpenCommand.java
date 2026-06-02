package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * This handles the command /team open
 * <p>
 * This toggles the team from being open to closed and back
 * </p>
 *
 * @author SparkyNox
 */
public class OpenCommand extends TeamSubCommand {

	@Override
	public CommandResponse onCommand(TeamPlayer teamPlayer, String label, String[] args, Team team) {

		team.setOpen(!team.isOpen());

		if (team.isOpen()) {
			return new CommandResponse(true, "open.successopen");
		}
		return new CommandResponse(true, "open.successclose");

	}

	@Override
	public String getCommand() {
		return "open";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public String getNode() {
		return "open";
	}

	@Override
	public String getHelp() {
		return "Toggle if the team is invite only";
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
		return PlayerRank.OWNER;
	}
}
