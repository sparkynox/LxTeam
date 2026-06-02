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
public class TitlePlaceholderProvider implements IndividualTeamPlayerPlaceholderProvider {

	@Override
	public String getPlaceholderForTeamPlayer(Team team, TeamPlayer player) {

		if (player.getTitle() == null || player.getTitle().isEmpty()) {
			return MessageManager.getMessage("placeholder.noTitle");
		}

		return player.getTitle();
	}

}
