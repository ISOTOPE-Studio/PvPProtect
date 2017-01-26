package cc.isotopestudio.pvpprotect.command;
/*
 * Created by david on 2017/1/26.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.pvpprotect.util.S;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cc.isotopestudio.pvpprotect.PvPProtect.playerData;

public class CommandPvPOn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvpon")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            if (playerData.isSet(player.getName())) {
                if (playerData.getBoolean(player.getName())) {
                    playerData.set(player.getName(), false);
                    playerData.save();
                    player.sendMessage(S.toPrefixYellow("已提前结束PvP保护"));
                } else {
                    player.sendMessage(S.toPrefixRed("你已经已提前结束PvP保护了"));
                }
                return true;
            }
            player.sendMessage(S.toPrefixRed("你已经已提前结束PvP保护了"));
            return true;
        }
        return false;
    }
}