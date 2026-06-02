package com.lumi.sparkynox.events;

import com.lumi.sparkynox.Main;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.customEvents.post.PostDisbandTeamEvent;
import com.lumi.sparkynox.customEvents.post.PostPlayerJoinTeamEvent;
import com.lumi.sparkynox.customEvents.post.PostPlayerLeaveTeamEvent;
import com.lumi.sparkynox.message.Message;
import com.lumi.sparkynox.message.ReferencedFormatMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MessagesManagement implements Listener {

	private enum TeamAnnouncement {
		JOIN("announceTeamJoin", "announce.join"),
		LEAVE("announceTeamLeave", "announce.leave"),
		DISBAND("announceTeamDisband", "announce.disband");

		private final String configKey;
		private final String messageKey;

		TeamAnnouncement(String configKey, String messageKey) {
			this.configKey = configKey;
			this.messageKey = messageKey;
		}
	}

	private void broadcastTeamMessage(@NotNull TeamAnnouncement type, @NotNull Team team, @Nullable String playerName) {
		if (!Main.plugin.getConfig().getBoolean(type.configKey)) {
			return;
		}

		Message message;
		String coloredTeamName = team.getColor() + team.getName() + ChatColor.RESET;

		if (playerName != null) {
			message = new ReferencedFormatMessage(type.messageKey, playerName, coloredTeamName);
		} else {
			message = new ReferencedFormatMessage(type.messageKey, coloredTeamName);
		}

		for (Player player : Bukkit.getOnlinePlayers()) {
			message.sendMessage(player);
		}
	}

	@EventHandler
	public void onPostPlayerJoinTeamEvent(@NotNull PostPlayerJoinTeamEvent e) {
		broadcastTeamMessage(TeamAnnouncement.JOIN, e.getTeam(), e.getPlayer().getName());
	}

	@EventHandler
	public void onPostPlayerLeaveTeamEvent(@NotNull PostPlayerLeaveTeamEvent e) {
		broadcastTeamMessage(TeamAnnouncement.LEAVE, e.getTeam(), e.getPlayer().getName());
	}

	@EventHandler
	public void onPostDisbandTeamEvent(@NotNull PostDisbandTeamEvent e) {
		broadcastTeamMessage(TeamAnnouncement.DISBAND, e.getTeam(), e.getPlayer() == null ? null : e.getPlayer().getName());
	}
}