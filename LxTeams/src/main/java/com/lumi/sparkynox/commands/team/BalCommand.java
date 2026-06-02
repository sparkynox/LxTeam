package com.lumi.sparkynox.commands.team;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.commands.presets.TeamSubCommand;
import com.lumi.sparkynox.message.ReferencedFormatMessage;
import org.bukkit.command.CommandSender;

import java.util.List;

public class BalCommand extends TeamSubCommand {

	@Override
	public CommandResponse onCommand(TeamPlayer player, String label, String[] args, Team team) {
		return new CommandResponse(true, new ReferencedFormatMessage("info.money", team.getBalance()));
	}

	@Override
	public String getCommand() {
		return "bal";
	}

	@Override
	public String getNode() {
		return "balance";
	}

	@Override
	public String getHelp() {
		return "View your teams balance";
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
		return PlayerRank.DEFAULT;
	}

}
