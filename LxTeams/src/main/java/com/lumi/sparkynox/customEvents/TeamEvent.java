package com.lumi.sparkynox.customEvents;

import com.lumi.sparkynox.Team;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * Wrapper for all events which contain a team
 *
 * @author SparkyNox
 */
@Getter
@Setter
public abstract class TeamEvent extends Event implements Cancellable {

	protected final Team team;
	protected boolean cancelled = false;

	protected TeamEvent(Team team, final boolean isAsync) {
		super(isAsync);

		this.team = team;
	}
}
