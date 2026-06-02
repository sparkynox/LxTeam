package com.lumi.sparkynox.customEvents;

import com.lumi.sparkynox.PlayerRank;
import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.TeamPlayer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RankChangePlayerEvent extends TeamPlayerEvent {

	final private PlayerRank currentRank;
	private PlayerRank newRank;

	public RankChangePlayerEvent(Team team, TeamPlayer teamPlayer, PlayerRank currentRank, PlayerRank newRank, boolean isAsync) {
		super(team, teamPlayer, isAsync);

		this.currentRank = currentRank;
		this.newRank = newRank;
	}
}
