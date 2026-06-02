package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;

public class ColorNamePlaceholderProvider implements IndividualTeamPlaceholderProvider {
	@Override
	public String getPlaceholderForTeam(com.lumi.sparkynox.Team team) {
		return team.getColor().name();
	}
}
