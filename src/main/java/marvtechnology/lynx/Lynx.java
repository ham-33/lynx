package marvtechnology.lynx;

import org.bukkit.plugin.java.JavaPlugin;

public class Lynx extends JavaPlugin {
    private static Lynx instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("Lynx enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Lynx disabled");
    }

    public static Lynx getInstance() {
        return instance;
    }
}
