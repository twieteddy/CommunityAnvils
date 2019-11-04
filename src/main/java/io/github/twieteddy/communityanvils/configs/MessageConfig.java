package io.github.twieteddy.communityanvils.configs;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class MessageConfig implements Config {

  private final CommunityAnvils plugin;
  private final File file;
  private final Map<MessageNode, String> messages;
  private final Logger logger;


  public MessageConfig(CommunityAnvils plugin) {
    this.plugin = plugin;
    this.logger = plugin.getLogger();
    this.file = new File(plugin.getDataFolder(), "messages.yml");
    this.messages = new HashMap<>();

    
    reload();
  }

  @Override
  public void reload() {
    if (!file.exists()) {
      plugin.saveResource("messages.yml", true);
    }

    YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

    for (MessageNode node : MessageNode.values()) {
      try {
        String message = yaml.getString(node.toString());
        Objects.requireNonNull(message, String.format("No entry for %s found", node.toString()));
        messages.put(node, ChatColor.translateAlternateColorCodes('&', message));
        logger.fine(String.format("%s: %s", node.toString(), message));
      } catch (NullPointerException e) {
        logger.warning(e.getMessage());
      }
    }
  }

  public String getMessage(MessageNode node) {
    return messages.getOrDefault(node, node.toString());
  }
}
