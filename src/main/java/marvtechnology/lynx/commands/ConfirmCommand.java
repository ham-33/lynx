package marvtechnology.lynx.commands;

import marvtechnology.lynx.country.CountryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfirmCommand implements CommandExecutor {
    private final CountryManager manager;

    public ConfirmCommand(CountryManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only");
            return true;
        }
        if (manager.confirmRequest((Player) sender)) {
            sender.sendMessage("Request accepted");
        } else {
            sender.sendMessage("No request found");
        }
        return true;
    }
}
