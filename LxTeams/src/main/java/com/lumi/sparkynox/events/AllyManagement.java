package com.lumi.sparkynox.events;

import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.message.MessageManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class AllyManagement implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Team team = Team.getTeam(e.getPlayer());
		if (team == null) {
			return;
		}

		if (team.getAllyRequests().isEmpty()) {
			return;
		}

		TeamPlayer player = team.getTeamPlayer(e.getPlayer());

		if (Objects.requireNonNull(player).getRank() == PlayerRank.OWNER) {
			MessageManager.sendMessage(e.getPlayer(), "ally.onJoin");
		}
	}

}
