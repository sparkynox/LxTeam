package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;
import com.lumi.sparkynox.message.MessageManager;

public class HasHomePlaceholderProvider implements IndividualTeamPlaceholderProvider {
	@Override
	public String getPlaceholderForTeam(Team team) {
		return team.getTeamHome() != null ? MessageManager.getMessage("placeholder.hasHome") : MessageManager.getMessage("placeholder.noHome");
	}
}
