package com.lumi.sparkynox.commands;

import com.lumi.sparkynox.gui.TeamGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * /lxteam - opens the Team GUI menu.
 * All sub-commands still work normally (passed through to the original system).
 * When called with no args, opens GUI.
 *
 * @author SparkyNox
 */
public class LxTeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        if (args.length == 0) {
            // no args = open GUI
            TeamGUI.open(player);
            return true;
        }

        // Has args = pass through to the old team command system via performCommand
        // e.g. /lxteam create MyTeam -> handled by BooksawCommand registered as "lxteam"
        // This executor only handles the no-arg case (GUI open).
        // Sub-command dispatch is handled by BooksawCommand.
        return false;
    }
}
