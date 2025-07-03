package marvtechnology.lynx.faction.service;

import marvtechnology.lynx.faction.FactionManager;

/**
 * Higher level operations for factions.
 */
public class FactionService {
    private final FactionManager manager;

    public FactionService(FactionManager manager) {
        this.manager = manager;
    }

    public void create(String name) {
        manager.createFaction(name);
    }
}
