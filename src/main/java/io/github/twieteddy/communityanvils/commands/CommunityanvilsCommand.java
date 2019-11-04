package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvilsPlugin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandBroker implements CommandExecutor {

  private HashMap<String, SubCommand> commands = new HashMap<>();
  private SubCommand helpCommand;

  public CommandBroker(CommunityAnvilsPlugin plugin) {
    helpCommand = new HelpCommand(plugin);
    commands.put("create", new CreateCommand(plugin));
    commands.put("delete", new DeleteCommand(plugin));
    commands.put("abort", new AbortCommand(plugin));
    commands.put("list", new ListCommand(plugin));
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd,
      @NotNull String alias, @NotNull String[] args) {

    List<String> arguments = Arrays.asList(args);
    String command = (!arguments.isEmpty()) ? arguments.get(0) : "help";
    sender.sendMessage(command);
    sender.sendMessage(Integer.toString(arguments.size()));

    SubCommand sub = commands.getOrDefault(command, helpCommand);
    return sub.execute(sender, cmd, alias, arguments);
  }
}
