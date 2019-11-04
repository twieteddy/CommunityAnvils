package io.github.twieteddy.communityanvils.listeners;

import io.github.twieteddy.communityanvils.Anvils;
import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RepairItemOnInteract implements Listener {

  private static CommunityAnvilsPlugin plugin;

  public RepairItemOnInteract(CommunityAnvilsPlugin p) {
    this.plugin = p;
  }


  @EventHandler
  public static void onPlayerInteractEvent(PlayerInteractEvent e) {

    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (!Anvils.getInstance().isCommunityAnvil(e.getClickedBlock())) {
      e.getPlayer().sendMessage(plugin.getMessage(MessageNode.NOT_A_COMMUNITY_ANVIL));
      return;
    }

    e.getPlayer().getInventory().getItemInMainHand().setDurability((short) 0);
    e.getPlayer().sendMessage(plugin.getMessage(MessageNode.ITEM_REPAIRED));
    e.setCancelled(true);
  }
}
