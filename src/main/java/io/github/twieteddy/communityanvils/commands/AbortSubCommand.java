package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.MessageConfig;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import io.github.twieteddy.communityanvils.utils.InteractModeManager;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AbortSubCommand implements SubCommand {

  private final MessageConfig messages;

  AbortSubCommand(CommunityAnvils plugin) {
    this.messages = plugin.getMessageConfig();
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(messages.getMessage(MessageNode.SENDER_NOT_PLAYER));
      return false;
    }

    Player p = (Player) sender;
    if (!InteractModeManager.getInstance().containsPlayer(p)) {
      sender.sendMessage(messages.getMessage(MessageNode.NOTHING_TO_ABORT));
      return false;
    }

    InteractModeManager.getInstance().removeState(p);
    sender.sendMessage(messages.getMessage(MessageNode.ABORTED));
    return true;
  }
}
