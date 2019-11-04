package io.github.twieteddy.communityanvils.commands;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

interface SubCommand {

  @SuppressWarnings("unused")
  boolean execute(CommandSender sender, Command cmd, String alias, List<String> args);
}
