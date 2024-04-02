package me.nettychannell.playersmalltext.utils;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
