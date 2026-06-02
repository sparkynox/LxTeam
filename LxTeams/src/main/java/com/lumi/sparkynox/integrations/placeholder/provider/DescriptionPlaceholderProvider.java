/**
 *
 */
package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;
import com.lumi.sparkynox.message.MessageManager;

/**
 * @author SparkyNox
 */
public class DescriptionPlaceholderProvider implements IndividualTeamPlaceholderProvider {
	@Override
	public String getPlaceholderForTeam(Team team) {
		if (team.getDescription() == null || team.getDescription().isEmpty()) {
			return MessageManager.getMessage("placeholder.noDescription");
		}

		return team.getDescription();
	}
}
