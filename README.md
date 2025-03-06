# Koukeneko Chat Plugin

## 🌟 Introduction

Koukeneko Chat is a simple, easy-to-use, and highly customizable Minecraft chat plugin that supports PlaceholderAPI, allowing you to quickly customize your server's chat format.

## 🔧 Features

- ✅ Customizable chat format
- ✅ Compatible with PlaceholderAPI and rich placeholders
- ✅ Simple command to reload configuration
- ✅ Supports color and text formatting

## 🔌 Dependencies

- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

## 📂 Installation

1. Place the plugin (`KoukenekoChat.jar`) into your server's `plugins` folder.
2. Ensure PlaceholderAPI is installed on your server.
3. Restart your server to activate the plugin.

## ⚙️ Configuration

Example configuration (`config.yml`):

```yaml
chat:
  enabled: true
  format: "&7[&6{display_name}&7] &f{message}"
```

You can use any PlaceholderAPI placeholders to customize your chat format.

## 🚀 Commands

- `/koukenekochatreload` (Permission: `koukeneko.chat.admin`)
  - Reloads the plugin's configuration.

## 🔑 Permissions

| Permission              | Description                   |
|-------------------------|-------------------------------|
| `koukeneko.chat.admin`  | Allows use of the reload command |

## ⚠️ Important Note

- Ensure `enforce-secure-profile` in your server's `server.properties` file is set to `false` if players encounter `[Not Secure]` chat warnings. This setting disables enforced secure chat profile requirements, which is especially useful for offline-mode servers or servers without valid profile signatures.

---

## 🌟 簡介

Koukeneko Chat 是一款簡單、易用且高度客製化的 Minecraft 聊天插件，支援 PlaceholderAPI，讓你能快速自訂伺服器聊天格式。

## 🔧 功能特色

- ✅ 支援自訂聊天格式
- ✅ 相容 PlaceholderAPI，支援豐富佔位符
- ✅ 提供重新載入設定的簡單指令
- ✅ 支援顏色與文字樣式

## 📌 相依插件

- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

## 📂 安裝方法

1. 將插件 (`KoukenekoChat.jar`) 放入伺服器的 `plugins` 資料夾。
2. 確認伺服器已安裝 PlaceholderAPI 插件。
3. 重新啟動伺服器以啟用插件。

## 🚀 指令

- `/koukenekochatreload` (權限: `koukeneko.chat.admin`)
  - 重新載入插件的設定檔。

## 🔑 權限

| 權限                      | 說明               |
|---------------------------|--------------------|
| `koukeneko.chat.admin`    | 允許使用重新載入指令 |

## ⚠️ 注意事項

- 如果伺服器聊天出現 `[Not Secure]` 警告訊息，請於伺服器的 `server.properties` 中將 `enforce-secure-profile` 設為 `false`。此設定適合離線模式或未使用有效玩家檔案簽名的伺服器。

---

🚀 Enjoy your game! 祝你遊戲愉快！
