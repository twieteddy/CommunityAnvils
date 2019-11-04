package io.github.twieteddy.communityanvils.listeners;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.AnvilConfig;
import io.github.twieteddy.communityanvils.configs.MessageConfig;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RepairPlayerInteractListener implements Listener {

  private final AnvilConfig anvils;
  private final MessageConfig messages;

  public RepairPlayerInteractListener(CommunityAnvils plugin) {
    this.anvils = plugin.getAnvilConfig();
    this.messages = plugin.getMessageConfig();
  }

  @SuppressWarnings("unused")
  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerInteractEvent(PlayerInteractEvent e) {

    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (!anvils.isCommunityAnvil(e.getClickedBlock())) {
      return;
    }

    e.getPlayer().getInventory().getItemInMainHand().setDurability((short) 0);
    e.getPlayer().sendMessage(messages.getMessage(MessageNode.ITEM_REPAIRED));
    e.setCancelled(true);
  }
}
