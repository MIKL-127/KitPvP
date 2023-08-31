package de.pixl.kitpvp.listeners;

import de.pixl.kitpvp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class SignInteractListener implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        if (event.getClickedBlock().getState() instanceof Sign) {
            String secretWarp = ((Sign) event.getClickedBlock().getState()).getLine(1);

            if (secretWarp.equalsIgnoreCase(" ")) {

                Inventory secretInventory = Bukkit.createInventory(null, 9 * 3, "§cSecret Inventory");

                secretInventory.setItem(13, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setDisplayname("§cTitan").setLocalizedName("titan").build());

                event.getPlayer().openInventory(secretInventory);
            }
        }
    }
}
