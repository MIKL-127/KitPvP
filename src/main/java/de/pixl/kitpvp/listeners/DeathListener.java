package de.pixl.kitpvp.listeners;

import de.pixl.kitpvp.KitPvP;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class DeathListener implements Listener {

    private final KitPvP plugin;

    public DeathListener(KitPvP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) throws InterruptedException {

        Player killer = event.getEntity().getKiller();
        Player deadPlayer = event.getEntity();

        if (deadPlayer.isDead()) {

            Location location = plugin.getConfig().getLocation("mainSpawn");

            if (location != null) {
                killer.teleport(location);
            }

            killer.getInventory().clear();
            killer.setHealth(20);
            killer.setSaturation(20);
            killer.playSound(killer, Sound.ENTITY_ENDER_DRAGON_DEATH, 0.3f, 1.0f);


            deadPlayer.playSound(deadPlayer, Sound.ENTITY_SHEEP_HURT, 3.0f, 1.0f);

            if (event instanceof Player) {
                Location deathLocation = event.getEntity().getLocation();
                World world = deathLocation.getWorld();
                world.strikeLightning(deathLocation);

                Bukkit.getScheduler().runTaskLater((Plugin) this, new Runnable() {

                    @Override
                    public void run() {
                        world.getBlockAt(deathLocation).setType(Material.AIR);
                    }
                }, 10L);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        Player deadPlayer = event.getPlayer();
        deadPlayer.getInventory().clear();

        Location location = plugin.getConfig().getLocation("mainSpawn");
        if (location != null) {
            event.setRespawnLocation(location);
        }
    }
}
