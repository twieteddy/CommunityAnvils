package io.github.twieteddy.communityanvils.listeners;

import io.github.twieteddy.communityanvils.Anvils;
import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import io.github.twieteddy.communityanvils.enums.Mode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ActionInteract implements Listener {

  private CommunityAnvilsPlugin plugin;

  public ActionInteract(CommunityAnvilsPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onCommand(PlayerInteractEvent e) {

    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
        return;
    }

    if (!plugin.getPlayerActionMap().containsKey(e.getPlayer())) {
      return;
    }

    if (Anvils.getInstance().isCommunityAnvil(e.getClickedBlock())) {
      e.getPlayer().sendMessage(plugin.getMessage(MessageNode.NOT_A_COMMUNITY_ANVIL));
      return;
    }

    Mode mode = plugin.getPlayerActionMap().remove(e.getPlayer());

    switch(mode) {
      case CREATE:
        e.getPlayer().sendMessage(plugin.getMessage(MessageNode.ANVIL_CREATED));
        break;
      case DELETE:
        e.getPlayer().sendMessage(plugin.getMessage(MessageNode.ANVIL_DELETED));
        break;
    }
  }
}
