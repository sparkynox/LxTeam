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
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * /creator command GUI - shows info about SparkyNox.
 *
 * @author SparkyNox
 */
public class CreatorGUI implements Listener {

    private static final String GUI_TITLE = ChatColor.GOLD + "" + ChatColor.BOLD + "✦ About Creator ✦";
    private static final int GUI_SIZE = 27;

    // SparkyNox skin texture URL
    private static final String SKIN_URL =
            "https://textures.minecraft.net/texture/db81b8b7dcf4afd3ef24d776d5ce4f26e2938640d67da9efd6e500adddef0c94";

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, GUI_SIZE, GUI_TITLE);

        // Purple glass border - top row
        for (int i = 0; i <= 8; i++) inv.setItem(i, filler(Material.PURPLE_STAINED_GLASS_PANE));
        // Purple glass border - bottom row
        for (int i = 18; i <= 26; i++) inv.setItem(i, filler(Material.PURPLE_STAINED_GLASS_PANE));
        // Sides
        inv.setItem(9,  filler(Material.PURPLE_STAINED_GLASS_PANE));
        inv.setItem(17, filler(Material.PURPLE_STAINED_GLASS_PANE));

        // Center - SparkyNox skull with custom skin
        inv.setItem(13, makeSkull());

        // Plugin info - slot 10
        inv.setItem(10, makeItem(Material.NETHER_STAR,
                ChatColor.GOLD + "SparkyNox",
                Arrays.asList(
                        ChatColor.GRAY + "Developer & Creator",
                        ChatColor.DARK_GRAY + "of LxTeams Plugin",
                        "",
                        ChatColor.YELLOW + "Discord: " + ChatColor.WHITE + "SparkyNox",
                        ChatColor.YELLOW + "ID: " + ChatColor.WHITE + "1359785315384033462"
                )));

        // Modrinth - slot 11
        inv.setItem(11, makeItem(Material.EMERALD,
                ChatColor.GREEN + "Modrinth",
                Arrays.asList(
                        ChatColor.GRAY + "Find more plugins by SparkyNox",
                        "",
                        ChatColor.AQUA + "modrinth.com/user/sparkynox"
                )));

        // Plugin info - slot 15
        inv.setItem(15, makeItem(Material.ENCHANTED_BOOK,
                ChatColor.LIGHT_PURPLE + "LxTeams Plugin",
                Arrays.asList(
                        ChatColor.GRAY + "A GUI-based teams plugin",
                        ChatColor.GRAY + "built on BetterTeams core.",
                        "",
                        ChatColor.YELLOW + "Version: " + ChatColor.WHITE + "1.0.0",
                        ChatColor.YELLOW + "MC: " + ChatColor.WHITE + "1.21+"
                )));

        // Yori Ecosystem - slot 16
        inv.setItem(16, makeItem(Material.PURPLE_DYE,
                ChatColor.DARK_PURPLE + "Yori Ecosystem",
                Arrays.asList(
                        ChatColor.GRAY + "Part of the Yori ecosystem",
                        ChatColor.GRAY + "of plugins and tools.",
                        "",
                        ChatColor.LIGHT_PURPLE + "Built with \u2764 by SparkyNox"
                )));

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        String title = event.getView().getTitle();
        if (title == null || !title.equals(GUI_TITLE)) return;
        event.setCancelled(true);
    }

    private static ItemStack makeSkull() {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        if (meta == null) return skull;

        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "✦ SparkyNox ✦");
        meta.setLore(Arrays.asList(
                ChatColor.GRAY + "Plugin Developer",
                ChatColor.GRAY + "Part of Yori Ecosystem",
                "",
                ChatColor.YELLOW + "Thanks for using LxTeams!"
        ));

        // Apply custom skin texture
        try {
            PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID(), "SparkyNox");
            PlayerTextures textures = profile.getTextures();
            textures.setSkin(new URL(SKIN_URL));
            profile.setTextures(textures);
            meta.setOwnerProfile(profile);
        } catch (MalformedURLException e) {
            Main.plugin.getLogger().warning("Failed to set creator skull skin: " + e.getMessage());
        }

        skull.setItemMeta(meta);
        return skull;
    }

    private static ItemStack makeItem(Material mat, String name, List<String> lore) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack filler(Material mat) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_GRAY + " ");
            item.setItemMeta(meta);
        }
        return item;
    }
}
