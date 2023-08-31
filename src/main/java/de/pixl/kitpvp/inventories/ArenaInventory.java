package de.pixl.kitpvp.inventories;

import de.pixl.kitpvp.KitPvP;
import de.pixl.kitpvp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ArenaInventory implements Listener {

    private final KitPvP plugin;

    public ArenaInventory(KitPvP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSignClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        if (event.getClickedBlock().getState() instanceof Sign) {
            String arenaWarp = ((Sign) event.getClickedBlock().getState()).getLine(1);

            if (arenaWarp.equalsIgnoreCase("§7[§1To Arena§7]")) {

                Inventory inventoryTeam = Bukkit.createInventory(null, 9 * 3, "§cArena Inventory");

                inventoryTeam.setItem(10, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setDisplayname("§aGreen Arena").setLocalizedName("greenArenaSpawn").build());
                inventoryTeam.setItem(12, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("§aBlue Arena").setLocalizedName("blueArenaSpawn").build());
                inventoryTeam.setItem(14, new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayname("§aYellow Arena").setLocalizedName("yellowArenaSpawn").build());
                inventoryTeam.setItem(16, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayname("§aRed Arena").setLocalizedName("redArenaSpawn").build());

                event.getPlayer().openInventory(inventoryTeam);
            }
        }
    }

    @EventHandler
    public boolean onInvClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§cArena Inventory")) {

            if (event.getCurrentItem() == null) {
                event.setCancelled(true);
                return false;
            }

            switch (event.getCurrentItem().getItemMeta().getLocalizedName()){

                case "greenArenaSpawn" -> {
                    Location greenArena = plugin.getConfig().getLocation("greenArena");

                    if (greenArena == null) {
                        player.sendMessage("The Arena spawn has not been set!");
                    } else {
                        player.teleport(greenArena);
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    }
                }
                case "yellowArenaSpawn" -> {
                    Location yellowArena = plugin.getConfig().getLocation("yellowArena");

                    if (yellowArena == null) {
                        player.sendMessage("No Arena spawn has been set!");
                    } else {
                        player.teleport(yellowArena);
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    }

                }
                case "redArenaSpawn" -> {
                    Location redArena = plugin.getConfig().getLocation("redArena");

                    if (redArena == null) {
                        player.sendMessage("No Arena spawn has been set!");
                    } else {
                        player.teleport(redArena);
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    }
                }
                case "blueArenaSpawn" -> {
                    Location blueArena = plugin.getConfig().getLocation("blueArena");

                    if (blueArena == null) {
                        player.sendMessage("No Arena spawn has been set!");
                    } else {
                        player.teleport(blueArena);
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    }
                }
            }
        }
        return false;
    }
}
