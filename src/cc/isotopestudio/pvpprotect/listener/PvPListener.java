package cc.isotopestudio.pvpprotect.listener;
/*
 * Created by david on 2017/1/26.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.pvpprotect.util.S;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static cc.isotopestudio.pvpprotect.PvPProtect.playerData;

public class PvPListener implements Listener {

    private static final String MSG1 = S.toPrefixRed("你无法PvP 输入 /pvpon 提前结束新手保护");
    private static final String MSG2 = S.toPrefixRed("此玩家无法PvP");

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageByEntityEvent event) {

        // Player Attack
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (event.getEntity() instanceof Player) {
                if (playerData.getBoolean(player.getName())) {
                    event.setCancelled(true);
                    player.sendMessage(MSG1);
                    ((Player) event.getEntity()).sendMessage(MSG2);
                }
            }
        } else if (event.getDamager() instanceof Projectile) {
            if (((Projectile) event.getDamager()).getShooter() instanceof Player) {
                Player player = (Player) ((Projectile) event.getDamager()).getShooter();
                if (event.getEntity() instanceof Player) {
                    if (playerData.getBoolean(player.getName())) {
                        event.setCancelled(true);
                        player.sendMessage(MSG1);
                        ((Player) event.getEntity()).sendMessage(MSG2);
                    }
                }
            }
        }

        // Player Damage
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            boolean pvp = false;
            Player damager = null;
            if (event.getDamager() instanceof Player) {
                pvp = true;
                damager = (Player) event.getDamager();
            } else if (event.getDamager() instanceof Projectile) {
                if (((Projectile) event.getDamager()).getShooter() instanceof Player) {
                    pvp = true;
                    damager = (Player) ((Projectile) event.getDamager()).getShooter();
                }
            }
            if (pvp && playerData.getBoolean(player.getName())) {
                event.setCancelled(true);
                damager.sendMessage(MSG2);
                player.sendMessage(MSG1);
            }
        }
    }

}
