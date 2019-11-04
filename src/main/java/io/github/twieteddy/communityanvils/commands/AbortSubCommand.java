package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AbortCommand extends SubCommand {

  private static String permission = "communityanvils.abort";

  AbortCommand(CommunityAnvilsPlugin plugin) {
    super(plugin);
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(plugin.getMessage(MessageNode.SENDER_NOT_PLAYER));
      return false;
    }

    if (sender.hasPermission(permission)) {
      sender.sendMessage(plugin.getMessage(MessageNode.NO_PERMISSION));
      return false;
    }

    if (!plugin.getPlayerActionMap().containsKey(sender)) {
      sender.sendMessage(plugin.getMessage(MessageNode.NOTHING_TO_ABORT));
      return false;
    }

    plugin.getPlayerActionMap().remove(sender);
    sender.sendMessage(plugin.getMessage(MessageNode.ABORTED));
    return true;
  }
}
