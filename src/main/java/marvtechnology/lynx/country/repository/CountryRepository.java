package marvtechnology.lynx.country.repository;

import marvtechnology.lynx.country.model.CountryModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Simple in-memory repository for countries.
 */
public class CountryRepository {
    private final Map<UUID, CountryModel> countries = new HashMap<>();

    public void save(CountryModel model) {
        countries.put(model.getId(), model);
    }

    public CountryModel find(UUID id) {
        return countries.get(id);
    }
}
