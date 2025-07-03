package marvtechnology.lynx.country.service;

import marvtechnology.lynx.country.Country;
import marvtechnology.lynx.country.CountryManager;
import org.bukkit.entity.Player;

/**
 * Higher level operations for countries.
 */
public class CountryService {
    private final CountryManager manager;

    public CountryService(CountryManager manager) {
        this.manager = manager;
    }

    public Country create(Player founder, String name) {
        return manager.createCountry(founder, name);
    }
}
