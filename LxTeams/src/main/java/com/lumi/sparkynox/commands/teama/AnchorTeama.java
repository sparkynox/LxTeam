package com.lumi.sparkynox.commands.teama;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.Utils;
import com.lumi.sparkynox.commands.SubCommand;

public class AnchorTeama extends SubCommand {

    @Override
    public CommandResponse onCommand(CommandSender sender, String label, String[] args) {

        OfflinePlayer p = Utils.getOfflinePlayer(args[0]);
        if (p == null)
            return new CommandResponse("noPlayer");

        Team team = Team.getTeam(p);
        if (team == null)
            return new CommandResponse("admin.inTeam");

        TeamPlayer tp = team.getTeamPlayer(p);
        team.setPlayerAnchor(tp, !tp.isAnchored());
        return tp.isAnchored() ? new CommandResponse(true, "admin.anchor.enabled")
                : new CommandResponse(true, "admin.anchor.disabled");

    }

    @Override
    public String getCommand() {
        return "anchor";
    }

    @Override
    public String getNode() {
        return "admin.anchor";
    }

    @Override
    public String getHelp() {
        return "Force a team player to allow or disallow their respawning at their team's home";
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
        if (args.length == 1)
            addPlayerStringList(options, args[0]);
    }

}
