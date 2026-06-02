package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Objects;

public class SethomeCommand extends TeamSubCommand {

	@Override
	public CommandResponse onCommand(TeamPlayer player, String label, String[] args, Team team) {

		team.setTeamHome(Objects.requireNonNull(player.getPlayer().getPlayer()).getLocation());

		return new CommandResponse(true, "sethome.success");

	}

	@Override
	public String getCommand() {
		return "sethome";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public String getNode() {
		return "sethome";
	}

	@Override
	public String getHelp() {
		return "Sets your team's home";
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
		return PlayerRank.ADMIN;
	}

}
