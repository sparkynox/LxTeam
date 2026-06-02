package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;

public class MoneyShortPlaceholderProvider implements IndividualTeamPlaceholderProvider {
	@Override
	public String getPlaceholderForTeam(Team team) {
		return team.getMoneyComponent().getMoneyShortFormatted();
	}
}
