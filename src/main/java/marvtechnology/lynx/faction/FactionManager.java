package marvtechnology.lynx.faction;

import java.util.*;

public class FactionManager {
    private final Map<String, Faction> factions = new HashMap<>();

    public void createFaction(String name) {
        factions.put(name.toLowerCase(), new Faction(name));
    }

    public Collection<String> listFactions() {
        List<String> names = new ArrayList<>();
        for (Faction f : factions.values()) {
            names.add(f.getName());
        }
        return names;
    }
}
