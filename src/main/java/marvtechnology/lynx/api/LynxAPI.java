package marvtechnology.lynx.api;

import marvtechnology.lynx.country.Country;
import marvtechnology.lynx.country.CountryManager;
import org.bukkit.entity.Player;

/**
 * Simple public API exposing basic country operations.
 */
public class LynxAPI {
    private final CountryManager countryManager;

    public LynxAPI(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    public Country createCountry(Player founder, String name) {
        Country country = countryManager.createCountry(founder, name);
        founder.getServer().getPluginManager().callEvent(
                new LynxNationCreateEvent(founder, name));
        return country;
    }
}
