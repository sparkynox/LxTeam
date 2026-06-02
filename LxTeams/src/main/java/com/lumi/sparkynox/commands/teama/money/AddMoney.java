package com.lumi.sparkynox.commands.teama.money;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.commands.presets.MoneySubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddMoney extends MoneySubCommand {
	@Override
	public CommandResponse onCommand(CommandSender sender, Team team, double change) {

		team.setMoney(team.getMoney() + change);

		return new CommandResponse("admin.bal.success");
	}

	@Override
	public String getCommand() {
		return "add";
	}

	@Override
	public String getNode() {
		return "admin.money.add";
	}

	@Override
	public String getHelp() {
		return "Add the specified amount to that players balance";
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
