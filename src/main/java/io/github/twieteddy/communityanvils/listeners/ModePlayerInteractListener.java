package io.github.twieteddy.communityanvils.listeners;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.AnvilConfig;
import io.github.twieteddy.communityanvils.configs.MessageConfig;
import io.github.twieteddy.communityanvils.enums.InteractMode;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import io.github.twieteddy.communityanvils.exceptions.BlockAlreadyCommunityAnvilException;
import io.github.twieteddy.communityanvils.exceptions.BlockNotAnvilException;
import io.github.twieteddy.communityanvils.exceptions.BlockNotCommunityAnvilException;
import io.github.twieteddy.communityanvils.utils.InteractModeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class ModePlayerInteractListener implements Listener {

  private final AnvilConfig anvils;
  private final MessageConfig messages;


  public ModePlayerInteractListener(CommunityAnvils plugin) {
    this.anvils = plugin.getAnvilConfig();
    this.messages = plugin.getMessageConfig();
  }

  @SuppressWarnings("unused")
  @EventHandler(priority = EventPriority.HIGH)
  public void onCommand(PlayerInteractEvent e) {

    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (!InteractModeManager.getInstance().containsPlayer(e.getPlayer())) {
      return;
    }

    e.setCancelled(true);
    InteractMode interactMode = InteractModeManager.getInstance().removeState(e.getPlayer());

    switch (interactMode) {
      case CREATE:
        try {
          anvils.addAnvil(e.getClickedBlock());
          e.getPlayer().sendMessage(messages.getMessage(MessageNode.ANVIL_CREATED));
        } catch (BlockNotAnvilException ex) {
          e.getPlayer().sendMessage(messages.getMessage(MessageNode.BLOCK_NOT_ANVIL));
        } catch (BlockAlreadyCommunityAnvilException ex) {
          e.getPlayer().sendMessage(messages.getMessage(MessageNode.BLOCK_ALREADY_COMMUNITY_ANVIL));
        }
        break;
      case DELETE:
        try {
          anvils.deleteAnvil(e.getClickedBlock());
          e.getPlayer().sendMessage(messages.getMessage(MessageNode.ANVIL_DELETED));
        } catch (BlockNotCommunityAnvilException ex) {
          e.getPlayer().sendMessage(messages.getMessage(MessageNode.BLOCK_NOT_COMMUNITY_ANVIL));
        }
        break;
      case NONE:
        break;
      default:

    }
  }
}
