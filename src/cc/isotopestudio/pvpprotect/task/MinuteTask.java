package cc.isotopestudio.pvpprotect.task;
/*
 * Created by david on 2017/1/26.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.pvpprotect.util.S;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Date;

import static cc.isotopestudio.pvpprotect.PvPProtect.playerData;

public class MinuteTask extends BukkitRunnable {

    public static int interval = 30;

    @Override
    public void run() {
        boolean changed = false;
        for (Player player : Bukkit.getOnlinePlayers()) {
            String playerName = player.getName();
//            System.out.println(playerName + " " + getPlayerJoinedTime(player));
            if (getPlayerJoinedTime(player) >= interval) {
                changed = true;
                if (playerData.isSet(playerName) && playerData.getBoolean(playerName)) {
                    player.sendMessage(S.toPrefixYellow("PvP保护时间已到"));
                }
                playerData.set(playerName, null);
            } else {
                if (!playerData.isSet(playerName)) {
                    changed = true;
                    playerData.set(playerName, true);
                }
            }
        }
        if (changed)
            playerData.save();
    }

    private static long getPlayerJoinedTime(Player player) {
        return getIntervalMinute(player.getFirstPlayed());
    }

    private static long getIntervalMinute(long time) {
        long now = new Date().getTime();
        return (long) ((now - time) / 1000.0 / 60);
    }

}
