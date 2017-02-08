package cc.isotopestudio.pvpprotect;

import cc.isotopestudio.pvpprotect.command.CommandPvPOn;
import cc.isotopestudio.pvpprotect.listener.PvPListener;
import cc.isotopestudio.pvpprotect.task.MinuteTask;
import cc.isotopestudio.pvpprotect.util.PluginFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PvPProtect extends JavaPlugin {

    private static final String pluginName = "PvPProtect";
    public static final String prefix = "§8[§a新手保护§8] ";

    public static PluginFile playerData;


    @Override
    public void onEnable() {
        PluginFile config = new PluginFile(this, "config.yml", "config.yml");
        config.setEditable(false);
        playerData = new PluginFile(this, "player.yml");

        this.getCommand("pvpon").setExecutor(new CommandPvPOn());

        Bukkit.getPluginManager().registerEvents(new PvPListener(), this);

        MinuteTask.interval = config.getInt("interval", 30);

        new MinuteTask().runTaskTimer(this, 1, 20);

        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "成功卸载!");
    }

}
