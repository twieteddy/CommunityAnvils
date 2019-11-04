package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpSubCommand implements SubCommand {

  HelpSubCommand(CommunityAnvils plugin) {

  }

  @Override
  public boolean execute(CommandSender sender, Command cmd, String alias, List<String> args) {
    return true;
  }
}