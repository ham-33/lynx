package marvtechnology.lynx.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event fired when a new nation is created.
 */
public class LynxNationCreateEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player founder;
    private final String countryName;

    public LynxNationCreateEvent(Player founder, String countryName) {
        this.founder = founder;
        this.countryName = countryName;
    }

    public Player getFounder() {
        return founder;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
