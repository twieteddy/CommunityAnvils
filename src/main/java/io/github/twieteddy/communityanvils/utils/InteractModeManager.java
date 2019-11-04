package io.github.twieteddy.communityanvils.utils;

import io.github.twieteddy.communityanvils.enums.NextInteract;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class InteractStateManager {

  private static InteractStateManager instance = null;
  private HashMap<Player, NextInteract> playerInteract = new HashMap<>();

  private InteractStateManager() {
  }

  public static InteractStateManager getInstance() {
    if (instance == null) {
      instance = new InteractStateManager();
    }
    return instance;
  }

  public void setState(Player p, NextInteract stage) {
    playerInteract.put(p, stage);
  }

  public NextInteract getState(Player p) {
    return playerInteract.getOrDefault(p, NextInteract.NONE);
  }

  public NextInteract removeState(Player p) {
    return playerInteract.containsKey(p) ? playerInteract.remove(p) : NextInteract.NONE;
  }

  public boolean containsPlayer(Player p) {
    return playerInteract.containsKey(p);
  }
}
