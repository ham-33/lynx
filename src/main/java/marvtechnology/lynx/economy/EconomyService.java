package marvtechnology.lynx.economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;

/**
 * Wrapper around Vault economy.
 */
public class EconomyService {
    private Economy economy;

    public void setup() {
        RegisteredServiceProvider<Economy> rsp =
                Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp != null) {
            economy = rsp.getProvider();
        }
    }

    public Economy getEconomy() {
        return economy;
    }
}
