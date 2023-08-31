package de.pixl.kitpvp.commands.arenaSpawnsSetter;

import de.pixl.kitpvp.KitPvP;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetBlueSpawn implements CommandExecutor {

    private final KitPvP plugin;

    public SetBlueSpawn(KitPvP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            if (player.isOp()) {

                Location location = player.getLocation();

                plugin.getConfig().set("blueArena", location);
                plugin.saveConfig();

                sender.sendMessage(ChatColor.GREEN + "The blue spawn has been set!");
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permissions to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
        }

        return true;
    }
}
