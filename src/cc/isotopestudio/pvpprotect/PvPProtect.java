package cc.isotopestudio.pvpprotect;

import cc.isotopestudio.pvpprotect.util.PluginFile;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PvPProtect extends JavaPlugin {

    private static final String pluginName = "PvPProtect";
    public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("PvPProtect").append("]").append(ChatColor.RED).toString();

    public static PvPProtect plugin;

    public static PluginFile config;
    public static PluginFile playerData;

    @Override
    public void onEnable() {
        plugin = this;
        config = new PluginFile(this, "config.yml", "config.yml");
        config.setEditable(false);
        playerData = new PluginFile(this, "player.yml");

        //this.getCommand("csclass").setExecutor(new CommandCsclass());

        getLogger().info(pluginName + "�ɹ�����!");
        getLogger().info(pluginName + "��ISOTOPE Studio����!");
        getLogger().info("http://isotopestudio.cc");
    }

    public void onReload() {
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "�ɹ�ж��!");
    }

}
