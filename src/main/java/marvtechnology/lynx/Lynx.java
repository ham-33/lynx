package marvtechnology.lynx;

import marvtechnology.lynx.commands.CountryCommand;
import marvtechnology.lynx.commands.FactionCommand;
import marvtechnology.lynx.commands.BankCommand;
import marvtechnology.lynx.commands.AdminCommand;
import marvtechnology.lynx.commands.LynxCommand;
import marvtechnology.lynx.country.CountryManager;
import marvtechnology.lynx.faction.FactionManager;
import marvtechnology.lynx.bank.BankManager;
import marvtechnology.lynx.map.MapSyncManager;
import marvtechnology.lynx.api.LynxAPI;
import marvtechnology.lynx.economy.EconomyService;
import marvtechnology.lynx.scheduler.BackupTask;
import marvtechnology.lynx.scheduler.MapAutoSyncTask;
import marvtechnology.lynx.scheduler.UpkeepTask;
import org.bukkit.plugin.java.JavaPlugin;

public class Lynx extends JavaPlugin {
    private static Lynx instance;
    private CountryManager countryManager;
    private FactionManager factionManager;
    private BankManager bankManager;
    private MapSyncManager mapSyncManager;
    private EconomyService economyService;
    private LynxAPI api;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        countryManager = new CountryManager();
        factionManager = new FactionManager();
        bankManager = new BankManager();
        mapSyncManager = new MapSyncManager(countryManager);
        economyService = new EconomyService();
        economyService.setup();
        api = new LynxAPI(countryManager);

        new UpkeepTask(countryManager).runTaskTimer(this, 20L * 60 * 60, 20L * 60 * 60);
        new MapAutoSyncTask(mapSyncManager).runTaskTimer(this, 20L * 60, 20L * 60);
        new BackupTask(new marvtechnology.lynx.backup.BackupManager()).runTaskTimer(this, 20L * 60 * 60 * 6, 20L * 60 * 60 * 6);

        getCommand("country").setExecutor(new CountryCommand(countryManager));
        getCommand("faction").setExecutor(new FactionCommand(factionManager));
        getCommand("lynx").setExecutor(new LynxCommand(countryManager, mapSyncManager));
        getCommand("admin").setExecutor(new AdminCommand(countryManager));
        getCommand("countrybank").setExecutor(new BankCommand(bankManager));

        getLogger().info("Lynx enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Lynx disabled");
    }

    public static Lynx getInstance() {
        return instance;
    }

    public LynxAPI getApi() {
        return api;
    }
}
