package marvtechnology.lynx.country;

import org.bukkit.Location;

public class Capital {
    private final Location location;

    public Capital(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
