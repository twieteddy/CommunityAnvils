package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.MessageConfig;
import io.github.twieteddy.communityanvils.enums.InteractMode;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import io.github.twieteddy.communityanvils.utils.InteractModeManager;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteSubCommand implements SubCommand {

  private final MessageConfig messages;

  DeleteSubCommand(CommunityAnvils plugin) {
    this.messages = plugin.getMessageConfig();
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(messages.getMessage(MessageNode.SENDER_NOT_PLAYER));
      return false;
    }

    Player p = (Player) sender;
    InteractModeManager manager = InteractModeManager.getInstance();

    if (manager.getState(p) != InteractMode.DELETE) {
      manager.setState(p, InteractMode.DELETE);
      p.sendMessage(messages.getMessage(MessageNode.DELETING_STARTED));
    } else {
      manager.removeState(p);
      p.sendMessage(messages.getMessage(MessageNode.DELETING_ABORTED));
    }

    return true;
  }
}

