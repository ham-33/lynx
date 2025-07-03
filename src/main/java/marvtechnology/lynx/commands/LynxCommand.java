package marvtechnology.lynx.commands;

import marvtechnology.lynx.country.CountryManager;
import marvtechnology.lynx.map.MapSyncManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LynxCommand implements CommandExecutor {
    private final CountryManager countryManager;
    private final MapSyncManager mapSyncManager;

    public LynxCommand(CountryManager countryManager, MapSyncManager mapSyncManager) {
        this.countryManager = countryManager;
        this.mapSyncManager = mapSyncManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("/lynx syncmap");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "syncmap":
                mapSyncManager.sync();
                sender.sendMessage("Squaremap synced");
                return true;
            case "accept":
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Players only");
                    return true;
                }
                if (countryManager.confirmRequest((Player) sender)) {
                    sender.sendMessage("Request accepted");
                } else {
                    sender.sendMessage("No request found");
                }
                return true;
            case "deny":
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Players only");
                    return true;
                }
                // simply remove request without action
                countryManager.confirmRequest((Player) sender);
                sender.sendMessage("Request denied");
                return true;
            default:
                sender.sendMessage("Unknown subcommand");
                return true;
        }
    }
}
