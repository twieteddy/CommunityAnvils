package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.Mode;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.util.HashMap;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteCommand extends SubCommand {

  private static String permission = "communityanvils.delete";

  public DeleteCommand(CommunityAnvilsPlugin plugin) {
    super(plugin);
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(plugin.getMessage(MessageNode.SENDER_NOT_PLAYER));
    }

    Player p = (Player) sender;
    HashMap<Player, Mode> playerActionMap = plugin.getPlayerActionMap();

    if (!playerActionMap.containsKey(p)) {
      playerActionMap.put(p, Mode.DELETE);
      p.sendMessage(plugin.getMessage(MessageNode.DELETING_STARTED));
      return true;
    }


    if (playerActionMap.get(p) != Mode.DELETE) {
      p.sendMessage(plugin.getMessage(MessageNode.MODE_ALREADY_SET));
    }

    return true;
  }
}

