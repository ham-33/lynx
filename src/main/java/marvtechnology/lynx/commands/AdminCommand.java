package marvtechnology.lynx.commands;

import marvtechnology.lynx.country.CountryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommand implements CommandExecutor {
    private final CountryManager manager;

    public AdminCommand(CountryManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2 && args[0].equalsIgnoreCase("country") && args[1].equalsIgnoreCase("list")) {
            sender.sendMessage("Countries: " + String.join(", ", manager.listCountries()));
            return true;
        }
        return false;
    }
}
