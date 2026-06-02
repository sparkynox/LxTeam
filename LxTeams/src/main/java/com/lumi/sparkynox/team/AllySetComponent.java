package com.lumi.sparkynox.team;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.message.Message;
import com.lumi.sparkynox.message.ReferencedFormatMessage;
import com.lumi.sparkynox.team.storage.team.TeamStorage;

import java.util.UUID;

public class AllySetComponent extends UuidSetComponent {

	@Override
	public String getSectionHeading() {
		return "allies";
	}

	@Override
	public void add(Team team, UUID ally) {
		super.add(team, ally);

		Team allyTeam = Team.getTeam(ally);
		// notifying all online members of the team
		Message message = new ReferencedFormatMessage("ally.ally", allyTeam.getDisplayName());
		team.getMembers().broadcastMessage(message);

		team.getStorage().addAlly(ally);
	}

	@Override
	public void remove(Team team, UUID component) {
		super.remove(team, component);

		team.getStorage().removeAlly(component);
	}

	@Override
	public void load(TeamStorage section) {
		load(section.getAllyList());
	}

	@Override
	public void save(TeamStorage storage) {
		storage.setAllyList(getConvertedList());
	}

}
