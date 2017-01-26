package cc.isotopestudio.pvpprotect.util;

import org.bukkit.ChatColor;

import static cc.isotopestudio.pvpprotect.PvPProtect.prefix;

/*
 * Created by Mars on 5/15/2016.
 * Copyright ISOTOPE Studio
 */
public class S {

    public static String toPrefixRed(String s) {
        return prefix + ChatColor.RED + s + ChatColor.RESET;
    }

    public static String toPrefixYellow(String s) {
        return prefix + ChatColor.YELLOW + s + ChatColor.RESET;
    }

}
