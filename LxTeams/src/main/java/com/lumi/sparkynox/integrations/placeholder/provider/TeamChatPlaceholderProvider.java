package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlayerPlaceholderProvider;
import com.lumi.sparkynox.message.MessageManager;

public class TeamChatPlaceholderProvider implements IndividualTeamPlayerPlaceholderProvider {
	@Override
	public String getPlaceholderForTeamPlayer(Team team, TeamPlayer player) {
		if (player.isInTeamChat()) {
			return MessageManager.getMessage("placeholder.teamChat");
		} else if (player.isInAllyChat()) {
			return MessageManager.getMessage("placeholder.allyChat");
		}
		return MessageManager.getMessage("placeholder.globalChat");
	}
}
