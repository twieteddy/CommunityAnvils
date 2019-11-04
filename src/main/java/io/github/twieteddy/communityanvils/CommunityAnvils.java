package io.github.twieteddy.communityanvils;

import io.github.twieteddy.communityanvils.commands.CommunityanvilsCommand;
import io.github.twieteddy.communityanvils.configs.AnvilConfig;
import io.github.twieteddy.communityanvils.configs.MessageConfig;
import io.github.twieteddy.communityanvils.listeners.ModePlayerInteractListener;
import io.github.twieteddy.communityanvils.listeners.RepairPlayerInteractListener;
import java.util.Objects;
import org.bukkit.plugin.java.JavaPlugin;


public class CommunityAnvils extends JavaPlugin {

  private MessageConfig messageConfig = null;
  private AnvilConfig anvilConfig = null;

  @Override
  public void onEnable() {
    messageConfig = new MessageConfig(this);
    anvilConfig = new AnvilConfig(this);

    Objects.requireNonNull(getCommand("communityanvils"))
        .setExecutor(new CommunityanvilsCommand(this));

    getServer().getPluginManager().registerEvents(new RepairPlayerInteractListener(this), this);
    getServer().getPluginManager().registerEvents(new ModePlayerInteractListener(this), this);
  }

  public MessageConfig getMessageConfig() {
    return messageConfig;
  }

  public AnvilConfig getAnvilConfig() {
    return anvilConfig;
  }

}
