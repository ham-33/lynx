package marvtechnology.lynx.country;

import org.bukkit.entity.Player;

import java.util.*;

public class CountryManager {
    private final Map<UUID, Country> countries = new HashMap<>();
    private final Map<UUID, UUID> pendingRequests = new HashMap<>();

    public void createCountry(Player founder, String name) {
        Country country = new Country(UUID.randomUUID(), name);
        countries.put(country.getId(), country);
    }

    public Collection<String> listCountries() {
        List<String> names = new ArrayList<>();
        for (Country c : countries.values()) {
            names.add(c.getName());
        }
        return names;
    }

    public void requestJoin(Player player, UUID countryId) {
        pendingRequests.put(player.getUniqueId(), countryId);
    }

    public boolean confirmRequest(Player player) {
        UUID id = pendingRequests.remove(player.getUniqueId());
        return id != null;
    }
}
