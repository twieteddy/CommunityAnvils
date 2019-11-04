package io.github.twieteddy.communityanvils.configs;

import com.mojang.brigadier.Message;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessageConfig {

  private final File file;
  private final Map<String, String> messages;
  private YamlConfiguration yaml;
  private Logger logger;
  private Config config;

  public MessageConfig(Config config) {
    this.config = config;
    logger = config.getLogger();
    file = new File(config.getPlugin().getDataFolder(), "messages.yml");
    messages = new HashMap<>();

    reload();
  }

  public void reload() {
    if (!file.exists()) {
      config.getPlugin().saveResource("messages.yml", true);
    }

    yaml = YamlConfiguration.loadConfiguration(file);
    messages.clear();


    setMessage(MessageNode.ANVIL_CREATED);
    setMessage(MessageNode.ANVIL_DELETED);

  }

  private void setMessage(String node) {
    Objects.requireNonNull(node, "Message node not found");
    Configuration root = Objects.requireNonNull(yaml.getRoot(), "Root empty");
    ConfigurationSection section = Objects.requireNonNull(root.getConfigurationSection("messages"));

    String message = Objects.requireNonNull(
        section.getString(node, node),
        String.format("Node %s not found", node));

    messages.put(node, ChatColor.translateAlternateColorCodes('&', message));
  }

}
