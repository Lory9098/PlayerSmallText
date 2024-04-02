package me.nettychannell.playersmalltext;

import me.nettychannell.playersmalltext.listeners.GeneralListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerSmallText extends JavaPlugin {

    private boolean placeholderAPIEnabled;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        placeholderAPIEnabled = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null && Bukkit.getPluginManager().getPlugin("PlaceholderAPI").isEnabled();

        if (placeholderAPIEnabled) {
            getLogger().info("PlaceholderAPI found! Enabling support for it.");
        }

        Bukkit.getPluginManager().registerEvents(new GeneralListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean isPlaceholderAPIEnabled() {
        return placeholderAPIEnabled;
    }

}
