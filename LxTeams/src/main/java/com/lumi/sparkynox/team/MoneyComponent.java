package com.lumi.sparkynox.team;

import com.lumi.sparkynox.team.storage.team.StoredTeamValue;
import com.lumi.sparkynox.util.MoneyUtils;

public class MoneyComponent extends DoubleTeamComponent {

	@Override
	public StoredTeamValue getSectionHeading() {
		return StoredTeamValue.MONEY;
	}

	public String getStringFormatting() {
		return MoneyUtils.getFormattedDouble(get());
	}

	public String getMoneyShortFormatted() {
		return MoneyUtils.getFormattedShortDouble(get());
	}

}
