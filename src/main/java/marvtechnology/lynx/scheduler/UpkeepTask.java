package marvtechnology.lynx.scheduler;

import marvtechnology.lynx.country.CountryManager;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Collects daily upkeep from each country.
 */
public class UpkeepTask extends BukkitRunnable {
    private final CountryManager countryManager;

    public UpkeepTask(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    @Override
    public void run() {
        // Placeholder: iterate countries and deduct upkeep
    }
}
