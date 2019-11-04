package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.AnvilConfig;
import io.github.twieteddy.communityanvils.utils.AnvilHelper;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ListSubCommand implements SubCommand {

  private final AnvilConfig anvilConfig;

  ListSubCommand(CommunityAnvils plugin) {
    this.anvilConfig = plugin.getAnvilConfig();
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {

    sender.sendMessage(ChatColor.DARK_GRAY + "Ambosse: ");
    return true;
  }
}
