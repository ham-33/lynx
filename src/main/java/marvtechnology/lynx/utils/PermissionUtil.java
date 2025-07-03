package marvtechnology.lynx.utils;

import org.bukkit.entity.Player;

public class PermissionUtil {
    public static boolean has(Player player, String permission) {
        return player.hasPermission(permission);
    }
}
