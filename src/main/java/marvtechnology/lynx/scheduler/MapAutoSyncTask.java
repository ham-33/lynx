package marvtechnology.lynx.scheduler;

import marvtechnology.lynx.map.MapSyncManager;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Periodically syncs Squaremap with country data.
 */
public class MapAutoSyncTask extends BukkitRunnable {
    private final MapSyncManager mapSyncManager;

    public MapAutoSyncTask(MapSyncManager mapSyncManager) {
        this.mapSyncManager = mapSyncManager;
    }

    @Override
    public void run() {
        mapSyncManager.sync();
    }
}
