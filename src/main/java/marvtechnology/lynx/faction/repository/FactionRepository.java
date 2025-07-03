package marvtechnology.lynx.faction.repository;

import marvtechnology.lynx.faction.model.FactionModel;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory faction repository.
 */
public class FactionRepository {
    private final Map<String, FactionModel> factions = new HashMap<>();

    public void save(FactionModel model) {
        factions.put(model.getName().toLowerCase(), model);
    }

    public FactionModel find(String name) {
        return factions.get(name.toLowerCase());
    }
}
