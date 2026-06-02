package com.lumi.sparkynox.gui;

import com.lumi.sparkynox.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * Main GUI for LxTeams - opens a colorful chest GUI instead of slash commands.
 *
 * @author SparkyNox
 */
public class TeamGUI implements Listener {

    private static final String GUI_TITLE = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "✦ LxTeam Menu ✦";
    private static final int GUI_SIZE = 54;

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, GUI_SIZE, GUI_TITLE);

        // Row 1: Team Management
        inv.setItem(0,  makeItem(Material.WRITABLE_BOOK,        ChatColor.GREEN + "Create Team",         ChatColor.GRAY + "Start a new team",                         "/lxteam create"));
        inv.setItem(1,  makeItem(Material.OAK_DOOR,             ChatColor.YELLOW + "Leave Team",          ChatColor.GRAY + "Leave your current team",                   "/lxteam leave"));
        inv.setItem(2,  makeItem(Material.TNT,                  ChatColor.RED + "Disband Team",           ChatColor.GRAY + "Permanently delete your team",              "/lxteam disband"));
        inv.setItem(3,  makeItem(Material.NAME_TAG,             ChatColor.AQUA + "Rename Team",           ChatColor.GRAY + "Change your team name",                     "/lxteam name"));
        inv.setItem(4,  makeItem(Material.PAPER,                ChatColor.GOLD + "Team Info",             ChatColor.GRAY + "View team details and stats",               "/lxteam info"));
        inv.setItem(5,  makeItem(Material.BOOK,                 ChatColor.LIGHT_PURPLE + "Description",   ChatColor.GRAY + "Set your team description",                 "/lxteam description"));
        inv.setItem(6,  makeItem(Material.ENDER_EYE,            ChatColor.DARK_AQUA + "Team List",        ChatColor.GRAY + "Browse all teams on the server",            "/lxteam list"));
        inv.setItem(7,  makeItem(Material.SPYGLASS,             ChatColor.WHITE + "Top Teams",            ChatColor.GRAY + "Leaderboard of top scoring teams",          "/lxteam top"));
        inv.setItem(8,  makeItem(Material.GOLD_INGOT,           ChatColor.GOLD + "Balance Top",           ChatColor.GRAY + "Top teams by bank balance",                 "/lxteam baltop"));

        // Row 2: Members
        inv.setItem(9,  makeItem(Material.PLAYER_HEAD,          ChatColor.GREEN + "Invite Player",        ChatColor.GRAY + "Invite someone to join your team",          "/lxteam invite"));
        inv.setItem(10, makeItem(Material.OAK_SIGN,             ChatColor.YELLOW + "Join Team",           ChatColor.GRAY + "Join a team you were invited to",           "/lxteam join"));
        inv.setItem(11, makeItem(Material.IRON_BOOTS,           ChatColor.GOLD + "Promote Member",        ChatColor.GRAY + "Promote a team member",                    "/lxteam promote"));
        inv.setItem(12, makeItem(Material.LEATHER_BOOTS,        ChatColor.RED + "Demote Member",          ChatColor.GRAY + "Demote a team member",                     "/lxteam demote"));
        inv.setItem(13, makeItem(Material.BARRIER,              ChatColor.DARK_RED + "Kick Member",       ChatColor.GRAY + "Remove a player from your team",            "/lxteam kick"));
        inv.setItem(14, makeItem(Material.IRON_BARS,            ChatColor.RED + "Ban Player",             ChatColor.GRAY + "Ban a player from joining your team",       "/lxteam ban"));
        inv.setItem(15, makeItem(Material.LIME_DYE,             ChatColor.GREEN + "Unban Player",         ChatColor.GRAY + "Remove a ban from a player",                "/lxteam unban"));
        inv.setItem(16, makeItem(Material.NETHER_STAR,          ChatColor.GOLD + "Set Owner",             ChatColor.GRAY + "Transfer team ownership",                  "/lxteam setowner"));
        inv.setItem(17, makeItem(Material.DIAMOND,              ChatColor.AQUA + "Team Rank",             ChatColor.GRAY + "View or manage player ranks",               "/lxteam rank"));

        // Row 3: Teleport / Warp
        inv.setItem(18, makeItem(Material.BED,                  ChatColor.GREEN + "Set Home",             ChatColor.GRAY + "Set your team home location",              "/lxteam sethome"));
        inv.setItem(19, makeItem(Material.COMPASS,              ChatColor.YELLOW + "Home",                ChatColor.GRAY + "Teleport to team home",                    "/lxteam home"));
        inv.setItem(20, makeItem(Material.REDSTONE,             ChatColor.RED + "Delete Home",            ChatColor.GRAY + "Remove your team home",                    "/lxteam delhome"));
        inv.setItem(21, makeItem(Material.ENDER_PEARL,          ChatColor.LIGHT_PURPLE + "Set Warp",      ChatColor.GRAY + "Create a team warp",                       "/lxteam setwarp"));
        inv.setItem(22, makeItem(Material.BLAZE_POWDER,         ChatColor.GOLD + "Warp",                  ChatColor.GRAY + "Teleport to a team warp",                  "/lxteam warp"));
        inv.setItem(23, makeItem(Material.MAGMA_CREAM,          ChatColor.YELLOW + "Warps List",          ChatColor.GRAY + "View all team warps",                      "/lxteam warps"));
        inv.setItem(24, makeItem(Material.FIRE_CHARGE,          ChatColor.RED + "Delete Warp",            ChatColor.GRAY + "Remove a team warp",                       "/lxteam delwarp"));
        inv.setItem(25, makeItem(Material.RESPAWN_ANCHOR,       ChatColor.DARK_AQUA + "Anchor",           ChatColor.GRAY + "Teleport to team anchor on respawn",       "/lxteam anchor"));
        inv.setItem(26, makeItem(Material.LODESTONE,            ChatColor.AQUA + "Set Anchor",            ChatColor.GRAY + "Set the team respawn anchor",              "/lxteam setanchor"));

        // Row 4: Chat / Social
        inv.setItem(27, makeItem(Material.BOOK,                 ChatColor.YELLOW + "Team Chat",           ChatColor.GRAY + "Toggle team-only chat mode",               "/lxteam chat"));
        inv.setItem(28, makeItem(Material.GOLDEN_APPLE,         ChatColor.GOLD + "Ally Chat",             ChatColor.GRAY + "Toggle ally chat mode",                    "/lxteam allychat"));
        inv.setItem(29, makeItem(Material.LIME_CONCRETE,        ChatColor.GREEN + "Add Ally",             ChatColor.GRAY + "Create an alliance with another team",     "/lxteam ally"));
        inv.setItem(30, makeItem(Material.GRAY_CONCRETE,        ChatColor.GRAY + "Neutral",               ChatColor.GRAY + "Remove alliance with a team",              "/lxteam neutral"));
        inv.setItem(31, makeItem(Material.RED_CONCRETE,         ChatColor.RED + "Toggle PvP",             ChatColor.GRAY + "Toggle friendly fire in your team",        "/lxteam pvp"));
        inv.setItem(32, makeItem(Material.PAINTING,             ChatColor.LIGHT_PURPLE + "Tag",           ChatColor.GRAY + "Set your team tag",                        "/lxteam tag"));
        inv.setItem(33, makeItem(Material.FEATHER,              ChatColor.WHITE + "Title",                ChatColor.GRAY + "Set a custom title for a member",          "/lxteam title"));
        inv.setItem(34, makeItem(Material.CYAN_DYE,             ChatColor.AQUA + "Team Color",            ChatColor.GRAY + "Change your team display color",           "/lxteam color"));
        inv.setItem(35, makeItem(Material.LEVER,                ChatColor.GOLD + "Open/Close Team",       ChatColor.GRAY + "Toggle open join for your team",           "/lxteam open"));

        // Row 5: Economy & Misc
        inv.setItem(36, makeItem(Material.GOLD_NUGGET,          ChatColor.GOLD + "Balance",               ChatColor.GRAY + "View your team bank balance",              "/lxteam bal"));
        inv.setItem(37, makeItem(Material.GOLD_INGOT,           ChatColor.YELLOW + "Deposit",             ChatColor.GRAY + "Deposit money into team bank",             "/lxteam deposit"));
        inv.setItem(38, makeItem(Material.GOLD_BLOCK,           ChatColor.GREEN + "Withdraw",             ChatColor.GRAY + "Withdraw money from team bank",            "/lxteam withdraw"));
        inv.setItem(39, makeItem(Material.CHEST,                ChatColor.DARK_GREEN + "Team Chest",      ChatColor.GRAY + "Claim a block as a team chest",            "/lxteam chest claim"));
        inv.setItem(40, makeItem(Material.ENDER_CHEST,          ChatColor.DARK_PURPLE + "E-Chest",        ChatColor.GRAY + "Open your personal ender chest",           "/lxteam echest"));
        inv.setItem(41, makeItem(Material.EMERALD,              ChatColor.GREEN + "Rank Up",              ChatColor.GRAY + "Spend score to rank up",                   "/lxteam rankup"));

        // Row 6: border + close button
        for (int i = 45; i < 54; i++) {
            if (i == 49) {
                inv.setItem(i, makeItem(Material.BARRIER, ChatColor.RED + "Close Menu", ChatColor.GRAY + "Close this menu", "close"));
            } else {
                inv.setItem(i, makeFiller(Material.BLACK_STAINED_GLASS_PANE));
            }
        }

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        String title = event.getView().getTitle();
        if (title == null || !title.equals(GUI_TITLE)) return;

        event.setCancelled(true);

        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || clicked.getType() == Material.AIR) return;
        if (!clicked.hasItemMeta() || !clicked.getItemMeta().hasLore()) return;

        List<String> lore = clicked.getItemMeta().getLore();
        if (lore == null || lore.isEmpty()) return;

        String raw = ChatColor.stripColor(lore.get(lore.size() - 1)).trim();

        if (raw.equals("close")) {
            player.closeInventory();
            return;
        }

        if (!raw.startsWith("/")) return;

        player.closeInventory();

        // Dispatch command
        String cmd = raw.substring(1);
        Bukkit.getScheduler().runTask(Main.plugin, () -> player.performCommand(cmd));
    }

    private static ItemStack makeItem(Material mat, String name, String desc, String command) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;

        meta.setDisplayName(name);

        if (command != null) {
            meta.setLore(Arrays.asList(
                    desc,
                    ChatColor.DARK_GRAY + "» Click to use",
                    ChatColor.BLACK + command
            ));
        } else {
            meta.setLore(Arrays.asList(desc));
        }

        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack makeFiller(Material mat) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_GRAY + " ");
            item.setItemMeta(meta);
        }
        return item;
    }
}
