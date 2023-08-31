package de.pixl.kitpvp.listeners;

import de.pixl.kitpvp.KitPvP;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ConnectionListener implements Listener {
    private final KitPvP plugin;

    public ConnectionListener(KitPvP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        Location location = plugin.getConfig().getLocation("mainSpawn");

        if (location != null) {
            player.teleport(location);
            player.sendMessage(ChatColor.GREEN + "Hey " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GREEN + "! Welcome on the server!");
        } else {
            player.sendMessage(ChatColor.RED + "No World spawn has been set! Please set a World spawn first to use this command!");
            player.sendMessage(ChatColor.RED + "For more information use </help Kitpvp>");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        Location location = plugin.getConfig().getLocation("mainSpawn");

        if (location != null) {
            event.setRespawnLocation(location);
        }
    }
}
