package com.lumi.sparkynox.integrations.placeholder;

import com.lumi.sparkynox.Team;

/**
 * Interface for placeholders that require additional data
 */
public interface IndividualTeamWithDataPlaceholderProvider {

	String getPlaceholderForTeam(Team team, String data);
}
