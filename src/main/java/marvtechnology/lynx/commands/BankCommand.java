package marvtechnology.lynx.commands;

import marvtechnology.lynx.bank.BankManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BankCommand implements CommandExecutor {
    private final BankManager manager;

    public BankCommand(BankManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("/country bank info");
            return true;
        }
        if (args[0].equalsIgnoreCase("info")) {
            sender.sendMessage("Balance: " + manager.getBalance());
            return true;
        }
        return false;
    }
}
