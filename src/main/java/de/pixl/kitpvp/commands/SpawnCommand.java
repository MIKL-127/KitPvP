package de.pixl.kitpvp.commands;

import de.pixl.kitpvp.KitPvP;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final KitPvP plugin;

    public SpawnCommand(KitPvP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player) {
            Location location = plugin.getConfig().getLocation("mainSpawn");

            if (location != null) {
                player.teleport(location);
                sender.sendMessage(ChatColor.GREEN + "You have been teleported to the spawn");
            } else {
                sender.sendMessage(ChatColor.RED + "No spawn has been set! Please set a spawn first to use this command!");
            }
        }

        return true;
    }
}
