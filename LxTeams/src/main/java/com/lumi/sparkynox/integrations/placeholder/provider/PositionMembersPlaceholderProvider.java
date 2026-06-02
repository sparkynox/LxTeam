package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;
import com.lumi.sparkynox.team.TeamManager;

public class PositionMembersPlaceholderProvider implements IndividualTeamPlaceholderProvider {

	@Override
	public String getPlaceholderForTeam(Team team) {
		return getPlaceholderForTeam(team, TeamManager::sortTeamsByMembers);
	}

}
