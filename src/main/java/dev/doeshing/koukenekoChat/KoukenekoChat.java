package dev.doeshing.koukenekoChat;

import dev.doeshing.koukenekoChat.commands.ReloadCommand;
import dev.doeshing.koukenekoChat.core.CommandSystem;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class KoukenekoChat extends JavaPlugin implements Listener {

    private CommandSystem commandSystem;
    private String chatFormat;

    @Override
    public void onEnable() {

        // 檢查 PlaceholderAPI 是否已安裝
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getPluginManager().registerEvents(this, this); //
        } else {
            getLogger().warning("PlaceholderAPI 未安裝，插件將無法正常運作！");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        // 使用 CommandSystem 註冊 reload 指令
        commandSystem = new CommandSystem(this);
        commandSystem.registerCommand("koukenekochatreload", new ReloadCommand(this), "koukeneko.chat.admin", "重新載入設定文件", "/koukenekochatreload", "kncreload");

        // 若 config.yml 尚未存在則複製預設配置
        saveDefaultConfig();

        // 取得聊天格式
        setChatFormat(
                getConfig().getString("chat-format", "&7[&6{displayname}&7] &r{message}")
        );

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * 重新載入設定檔
     */
    public void reloadConfig() {
        super.reloadConfig();
        setChatFormat(
                getConfig().getString("chat-format", "&7[&6%player_displayname%&7] &r{message}")
        );
    }

    /**
     * 設定聊天格式
     */
    public void setChatFormat(String format) {
        chatFormat = format;
    }

    /**
     * 偵聽玩家聊天事件，通常玩家可能使用 PlaceholderAPI 來取得顯示名稱 (%player_displayname%)
     */

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        //debug print
        getLogger().info("Chat event called -> " + event.getPlayer().getDisplayName() + ": " + event.getMessage());
        // 取得設定檔中的聊天格式
        String format = getConfig().getString("chat.format", "&7[&6{display_name}&7] &f{message}");
        // 替換 PlaceholderAPI 的 %佔位符%（若玩家有使用）
        format = PlaceholderAPI.setPlaceholders(event.getPlayer(), format);
        // 替換自定義佔位符 {display_name} 和 {message}
        format = format.replace("{display_name}", event.getPlayer().getDisplayName())
                .replace("{message}", event.getMessage());
        // 將格式轉為Adventure的Component（支援顏色與樣式）
        Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(format);
        // 廣播給所有玩家與主控台（完美支援顏色與格式）
        Bukkit.getServer().broadcast(component);

        event.setCancelled(true);
    }

}
