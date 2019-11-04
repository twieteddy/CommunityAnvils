package io.github.twieteddy.communityanvils.utils;

import io.github.twieteddy.communityanvils.enums.InteractMode;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class InteractModeManager {

  private static InteractModeManager instance = null;
  private final HashMap<Player, InteractMode> playerInteract = new HashMap<>();

  private InteractModeManager() {
  }

  public static InteractModeManager getInstance() {
    if (instance == null) {
      instance = new InteractModeManager();
    }
    return instance;
  }

  public void setState(Player p, InteractMode stage) {
    playerInteract.put(p, stage);
  }

  public InteractMode getState(Player p) {
    return playerInteract.getOrDefault(p, InteractMode.NONE);
  }

  public InteractMode removeState(Player p) {
    return playerInteract.containsKey(p) ? playerInteract.remove(p) : InteractMode.NONE;
  }

  public boolean containsPlayer(Player p) {
    return playerInteract.containsKey(p);
  }
}
