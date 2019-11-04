package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.Mode;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCommand extends SubCommand {
  private String permission = "communityanvils.create";

  public CreateCommand(CommunityAnvilsPlugin plugin) {
    super(plugin);
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(plugin.getMessage(MessageNode.SENDER_NOT_PLAYER));
      return false;
    }

    if (!sender.hasPermission(permission)) {
      sender.sendMessage(plugin.getMessage(MessageNode.NO_PERMISSION));
      return false;
    }

    Player p = (Player) sender;





    if (plugin.getPlayerActionMap().containsKey(p)) {

      p.sendMessage(plugin.getMessage(MessageNode.CREATING_ABORTED));
      plugin.getPlayerActionMap().remove(p);
      return true;

    }

    if (plugin.getPlayerActionMap().get(p) == Mode.CREATE) {
      p.sendMessage(plugin.getMessage(MessageNode.CREATING_STARTED));
      plugin.getPlayerActionMap().put(p, Mode.CREATE);
      return true;
    }

    p.sendMessage(plugin.getMessage(MessageNode.MODE_ALREADY_SET));
    return false;
  }

}