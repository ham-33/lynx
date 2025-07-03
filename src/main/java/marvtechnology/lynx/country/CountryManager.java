package marvtechnology.lynx.country;

import org.bukkit.entity.Player;

import marvtechnology.lynx.map.ColorUtil;

import java.util.*;

public class CountryManager {
    private final Map<UUID, Country> countries = new HashMap<>();
    private final Map<UUID, UUID> pendingRequests = new HashMap<>();

    public Country createCountry(Player founder, String name) {
        String colorHex = ColorUtil.randomHex();
        Country country = new Country(UUID.randomUUID(), name, new Capital(founder.getLocation()), colorHex);
        countries.put(country.getId(), country);
        return country;
    }

    public Collection<String> listCountries() {
        List<String> names = new ArrayList<>();
        for (Country c : countries.values()) {
            names.add(c.getName());
        }
        return names;
    }

    public Collection<Country> getCountries() {
        return countries.values();
    }

    public void requestJoin(Player player, UUID countryId) {
        pendingRequests.put(player.getUniqueId(), countryId);
    }

    public boolean confirmRequest(Player player) {
        UUID id = pendingRequests.remove(player.getUniqueId());
        return id != null;
    }
}
