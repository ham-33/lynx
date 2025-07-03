package marvtechnology.lynx.scheduler;

import marvtechnology.lynx.backup.BackupManager;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Runs automatic backups at a scheduled interval.
 */
public class BackupTask extends BukkitRunnable {
    private final BackupManager backupManager;

    public BackupTask(BackupManager backupManager) {
        this.backupManager = backupManager;
    }

    @Override
    public void run() {
        backupManager.backup();
    }
}
