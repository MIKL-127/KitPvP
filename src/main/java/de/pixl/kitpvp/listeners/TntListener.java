package de.pixl.kitpvp.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TntListener implements Listener {

    @EventHandler
    public void onTntExplode(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.PRIMED_TNT) {
            event.blockList().clear();
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.getBlockPlaced().getType().equals(Material.TNT)) {
            return;
        }
        event.getBlockPlaced().setType(Material.AIR);

        TNTPrimed tnt = (TNTPrimed) event.getBlockPlaced().getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
        tnt.setFuseTicks(20);
    }
}
