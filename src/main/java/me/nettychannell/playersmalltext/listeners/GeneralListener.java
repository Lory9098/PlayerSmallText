package me.nettychannell.playersmalltext.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.nettychannell.playersmalltext.PlayerSmallText;
import me.nettychannell.playersmalltext.utils.ChatUtils;
import me.nettychannell.playersmalltext.utils.SmallTextUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GeneralListener implements Listener {

    private final PlayerSmallText plugin;
    private final ConfigurationSection featuresSection;

    public GeneralListener(PlayerSmallText plugin) {
        this.plugin = plugin;
        this.featuresSection = plugin.getConfig().getConfigurationSection("features");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setDisplayName(SmallTextUtils.getSmallText(player.getDisplayName()));
        player.setPlayerListName(SmallTextUtils.getSmallText(player.getPlayerListName()));

        if (featuresSection.getBoolean("join-message.enabled")) {
            String rawFormat = featuresSection.getString("join-message.format");
            String format = rawFormat
                    .replace("%player%", SmallTextUtils.getSmallText(player.getName()))
                    .replace("%displayname%", SmallTextUtils.getSmallText(player.getDisplayName()));

            if (plugin.isPlaceholderAPIEnabled()) {
                format = PlaceholderAPI.setPlaceholders(player, format);
                format = PlaceholderAPI.setBracketPlaceholders(player, format);
            }

            e.setJoinMessage(ChatUtils.color(format));
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        if (featuresSection.getBoolean("chat-format.enabled")) {
            String rawFormat = featuresSection.getString("chat-format.format");
            String format = rawFormat
                    .replace("%player%", SmallTextUtils.getSmallText(player.getName()))
                    .replace("%displayname%", SmallTextUtils.getSmallText(player.getDisplayName()))
                    .replace("%message%", featuresSection.getBoolean("chat-format.message-small-text") ? SmallTextUtils.getSmallText(e.getMessage()) : e.getMessage());

            if (plugin.isPlaceholderAPIEnabled()) {
                format = PlaceholderAPI.setPlaceholders(player, format);
                format = PlaceholderAPI.setBracketPlaceholders(player, format);
            }

            e.setFormat(ChatUtils.color(format).replace("%","%%"));
        }
    }

}
