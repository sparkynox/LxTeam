/**
 *
 */
package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlayerPlaceholderProvider;
import com.lumi.sparkynox.message.MessageManager;

/**
 * @author SparkyNox
 */
public class RankPlaceholderProvider implements IndividualTeamPlayerPlaceholderProvider {

	@Override
	public String getPlaceholderForTeamPlayer(Team team, TeamPlayer player) {

		switch (player.getRank()) {
			case ADMIN:
				return MessageManager.getMessage("placeholder.admin");
			case OWNER:
				return MessageManager.getMessage("placeholder.owner");
			default:
				return MessageManager.getMessage("placeholder.default");
		}

	}

}