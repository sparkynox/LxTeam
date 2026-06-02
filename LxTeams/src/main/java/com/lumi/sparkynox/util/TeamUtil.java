package com.lumi.sparkynox.util;

import com.lumi.sparkynox.CommandResponse;
import com.lumi.sparkynox.Main;
import com.lumi.sparkynox.Team;
import org.jetbrains.annotations.Nullable;


public class TeamUtil {
	private TeamUtil() {

	}

	public static @Nullable CommandResponse verifyTeamName(@Nullable String teamName) {
		if (!Team.isValidTeamName(teamName)) {
			return new CommandResponse("create.banned");
		}

		int max = Math.min(55, Main.plugin.getConfig().getInt("maxTeamLength"));
		if (max != -1 && max < teamName.length()) {
			return new CommandResponse("create.maxLength");
		}

		int min = Math.max(0, Math.min(55, Main.plugin.getConfig().getInt("minTeamLength")));
		if (min != 0 && min > teamName.length()) {
			return new CommandResponse("create.minLength");
		}

		return null;
	}

	public static @Nullable CommandResponse verifyTagName(@Nullable String tagName) {
		if (!Team.isValidTeamName(tagName)) {
			return new CommandResponse("tag.banned");
		}

		int max = Math.min(55, Main.plugin.getConfig().getInt("maxTagLength"));
		if (max != -1 && max < tagName.length()) {
			return new CommandResponse("tag.maxLength");
		}

		return null;
	}
}
