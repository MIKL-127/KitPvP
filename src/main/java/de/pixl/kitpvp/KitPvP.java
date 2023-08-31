package de.pixl.kitpvp;

import de.pixl.kitpvp.commands.SetSpawnCommand;
import de.pixl.kitpvp.commands.SpawnCommand;
import de.pixl.kitpvp.commands.arenaSpawnsSetter.SetBlueSpawn;
import de.pixl.kitpvp.commands.arenaSpawnsSetter.SetGreenSpawn;
import de.pixl.kitpvp.commands.arenaSpawnsSetter.SetRedSpawn;
import de.pixl.kitpvp.commands.arenaSpawnsSetter.SetYellowSpawn;
import de.pixl.kitpvp.commands.arenaSpawnsTeleporter.BlueArenaCommand;
import de.pixl.kitpvp.commands.arenaSpawnsTeleporter.GreenArenaCommand;
import de.pixl.kitpvp.commands.arenaSpawnsTeleporter.RedArenaCommand;
import de.pixl.kitpvp.commands.arenaSpawnsTeleporter.YellowArenaCommand;
import de.pixl.kitpvp.inventories.ArenaInventory;
import de.pixl.kitpvp.inventories.KitInventory;
import de.pixl.kitpvp.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPvP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockListener(), this);
        pluginManager.registerEvents(new ConnectionListener(this), this);
        pluginManager.registerEvents(new DeathListener(this), this);
        pluginManager.registerEvents(new EpListener(), this);
        pluginManager.registerEvents(new DropListener(), this);
        pluginManager.registerEvents(new TntListener(), this);

        pluginManager.registerEvents(new SignListener(), this);
        pluginManager.registerEvents(new SignInteractListener(), this);
        pluginManager.registerEvents(new ArenaInventory(this), this);
        pluginManager.registerEvents(new KitInventory(), this);


        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("setgreenarena").setExecutor(new SetGreenSpawn(this));
        getCommand("setyellowarena").setExecutor(new SetYellowSpawn(this));
        getCommand("setredarena").setExecutor(new SetRedSpawn(this));
        getCommand("setbluearena").setExecutor(new SetBlueSpawn(this));

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("bluearena").setExecutor(new BlueArenaCommand(this));
        getCommand("redarena").setExecutor(new RedArenaCommand(this));
        getCommand("greenarena").setExecutor(new GreenArenaCommand(this));
        getCommand("yellowarena").setExecutor(new YellowArenaCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
