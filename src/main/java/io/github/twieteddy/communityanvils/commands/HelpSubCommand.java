package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpCommand extends SubCommand {

  private String permission = "communityanvils.help";

  public HelpCommand(CommunityAnvilsPlugin plugin) {
    super(plugin);
  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {
    sender.sendMessage(("Hallo"));
    return true;
  }
}
