package com.lumi.sparkynox.commands.teama.money;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.commands.presets.MoneySubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class RemoveMoney extends MoneySubCommand {
	@Override
	public CommandResponse onCommand(CommandSender sender, Team team, double change) {

		team.setMoney(Math.max(team.getMoney() - change, 0));

		return new CommandResponse("admin.bal.success");
	}

	@Override
	public String getCommand() {
		return "remove";
	}

	@Override
	public String getNode() {
		return "admin.money.remove";
	}

	@Override
	public String getHelp() {
		return "Remove the specified amount from that players balance";
	}

	@Override
	public String getArguments() {
		return "<player/team> <balance>";
	}

	@Override
	public void onTabComplete(List<String> options, CommandSender sender, String label, String[] args) {
		if (args.length == 1) {
			addTeamStringList(options, args[0]);
			addPlayerStringList(options, args[0]);
		} else if (args.length == 2) {
			options.add("<balance>");
		}
	}
}
