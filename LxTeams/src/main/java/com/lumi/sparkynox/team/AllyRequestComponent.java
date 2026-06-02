package com.lumi.sparkynox.team;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.message.Message;
import com.lumi.sparkynox.message.ReferencedFormatMessage;
import com.lumi.sparkynox.team.storage.team.TeamStorage;

import java.util.UUID;

public class AllyRequestComponent extends UuidSetComponent {

	@Override
	public void load(TeamStorage section) {
		load(section.getAllyRequestList());
	}

	@Override
	public void save(TeamStorage storage) {
		storage.setAllyRequestList(getConvertedList());
	}

	@Override
	public String getSectionHeading() {
		return "allyrequests";
	}

	@Override
	public void add(Team team, UUID component) {
		super.add(team, component);

		Team t = Team.getTeam(component);
		// notifying all online owners of the team
		Message message = new ReferencedFormatMessage("ally.request", t.getDisplayName());
		team.getMembers().broadcastMessage(message);

		team.getStorage().addAllyRequest(component);

	}

	@Override
	public void remove(Team team, UUID component) {
		super.remove(team, component);

		team.getStorage().removeAllyRequest(component);
	}

}
