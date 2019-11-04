package io.github.twieteddy.communityanvils;

import io.github.twieteddy.communityanvils.commands.CommunityanvilsCommand;
import io.github.twieteddy.communityanvils.enums.Mode;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import io.github.twieteddy.communityanvils.listeners.RepairPlayerInteractListener;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("WeakerAccess")
public class CommunityAnvilsPlugin extends JavaPlugin {

  private Messages messages = new Messages(this);
  private HashMap<Player, Mode> actionMap = new HashMap<>();

  @Override
  public void onEnable() {
    this.getCommand("communityanvils").setExecutor(new CommunityanvilsCommand(this));
    this.getServer().getPluginManager().registerEvents(new RepairPlayerInteractListener(this), this);
  }

  @Override
  public void onDisable() {
  }

  public String getMessage(MessageNode node) {
    return messages.get(node);
  }

  public HashMap<Player, Mode> getPlayerActionMap() {
    return actionMap;
  }
}
