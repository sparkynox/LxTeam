package com.lumi.sparkynox.integrations.placeholder;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;

/**
 * @author SparkyNox
 */
public interface IndividualTeamPlayerPlaceholderProvider {

	String getPlaceholderForTeamPlayer(Team team, TeamPlayer player);


}
