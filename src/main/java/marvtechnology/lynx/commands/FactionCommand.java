package marvtechnology.lynx.commands;

import marvtechnology.lynx.faction.FactionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FactionCommand implements CommandExecutor {
    private final FactionManager manager;

    public FactionCommand(FactionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("/faction create <name>");
            return true;
        }
        if (args[0].equalsIgnoreCase("create") && args.length >= 2) {
            String name = args[1];
            manager.createFaction(name);
            sender.sendMessage("Faction created: " + name);
            return true;
        }
        return false;
    }
}
