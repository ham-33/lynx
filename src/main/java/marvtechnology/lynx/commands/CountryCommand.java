package marvtechnology.lynx.commands;

import marvtechnology.lynx.country.CountryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CountryCommand implements CommandExecutor {
    private final CountryManager manager;

    public CountryCommand(CountryManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("/country create <name>");
            return true;
        }
        if (args[0].equalsIgnoreCase("create") && args.length >= 2) {
            String name = args[1];
            manager.createCountry((Player) sender, name);
            sender.sendMessage("Country created: " + name);
            return true;
        }
        return false;
    }
}
