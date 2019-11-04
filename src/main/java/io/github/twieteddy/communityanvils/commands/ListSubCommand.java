package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.Anvils;
import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import io.github.twieteddy.communityanvils.enums.MessageNode;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand extends SubCommand {

  private String permission = "communityanvils.list";

  public ListCommand(CommunityAnvilsPlugin plugin) {
    super(plugin);
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    if (!(sender instanceof Player)) {
      sender.sendMessage(plugin.getMessage(MessageNode.SENDER_NOT_PLAYER));
    }

    Player p = (Player) sender;

    if (p.hasPermission(permission)) {
      p.sendMessage(plugin.getMessage(MessageNode.NO_PERMISSION));
      return false;
    }


    p.sendMessage(ChatColor.DARK_GRAY + "Ambosse: ");

    Anvils.getInstance().getAnvilLocations().forEach(location -> p.sendMessage(location.toString()));

    return true;
  }
}
