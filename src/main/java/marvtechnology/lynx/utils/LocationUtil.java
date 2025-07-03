package marvtechnology.lynx.utils;

import org.bukkit.Location;

public class LocationUtil {
    public static String serialize(Location loc) {
        return loc.getWorld().getName()+","+loc.getBlockX()+","+loc.getBlockY()+","+loc.getBlockZ();
    }
}
