package de.pixl.kitpvp.commands.arenaSpawnsTeleporter;

import de.pixl.kitpvp.KitPvP;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GreenArenaCommand implements CommandExecutor {

private final KitPvP plugin;

    public GreenArenaCommand(KitPvP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player) {
            Location location = plugin.getConfig().getLocation("greenArena");

            if (location != null) {
                player.teleport(location);
                sender.sendMessage(ChatColor.GREEN + "You have been teleported to the green arena spawn");
            } else {
                sender.sendMessage(ChatColor.RED + "No green spawn has been set! Please set a spawn first to use this command!");
            }
        }

        return true;
    }
}
