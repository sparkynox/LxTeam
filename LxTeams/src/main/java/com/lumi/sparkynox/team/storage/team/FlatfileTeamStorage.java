package com.lumi.sparkynox.team.storage.team;

import com.lumi.sparkynox.Team;
import com.lumi.sparkynox.team.storage.storageManager.FlatfileStorageManager;
import org.bukkit.configuration.ConfigurationSection;

public class FlatfileTeamStorage extends YamlTeamStorage {

	public FlatfileTeamStorage(Team team, FlatfileStorageManager teamStorage) {
		super(team, teamStorage);
	}

	public ConfigurationSection getConfig() {
		ConfigurationSection section = teamStorage.getTeamStorage().getConfigurationSection(getConfigPath());
		if (section == null) {
			section = teamStorage.getTeamStorage().createSection(getConfigPath());
		}
		return section;
	}

	private String getConfigPath() {
		return "team." + team.getID();
	}

	@Override
	protected void saveFile() {
		teamStorage.saveTeamsFile();
	}

}
