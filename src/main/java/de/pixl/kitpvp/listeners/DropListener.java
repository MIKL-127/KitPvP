package de.pixl.kitpvp.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.SURVIVAL) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
}
