/**
 *
 */
package com.lumi.sparkynox.integrations.placeholder.provider;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.integrations.placeholder.IndividualTeamPlaceholderProvider;
import com.lumi.sparkynox.util.MoneyUtils;

/**
 * @author SparkyNox
 */
public class MaxMoneyPlaceholderProvider implements IndividualTeamPlaceholderProvider {

	@Override
	public String getPlaceholderForTeam(Team team) {
		return MoneyUtils.getFormattedDouble(team.getMaxMoney());
	}


}
