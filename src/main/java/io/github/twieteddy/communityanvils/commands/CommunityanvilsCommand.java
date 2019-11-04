package io.github.twieteddy.communityanvils.commands;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.configs.Config;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommunityanvilsCommand implements CommandExecutor {

  private final HashMap<String, SubCommand> commands = new HashMap<>();
  private final SubCommand helpSubCommand;

  public CommunityanvilsCommand(CommunityAnvils plugin) {
    this.helpSubCommand = new HelpSubCommand(plugin);
    this.commands.put("help", helpSubCommand);
    this.commands.put("create", new CreateSubCommand(plugin));
    this.commands.put("delete", new DeleteSubCommand(plugin));
    this.commands.put("abort", new AbortSubCommand(plugin));
    this.commands.put("list", new ListSubCommand(plugin));
  }

  @SuppressWarnings("NullableProblems")
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
    List<String> arguments = Arrays.asList(args);
    boolean isValidSubcommand = arguments.size() == 0 || !commands.containsKey(arguments.get(0));
    SubCommand sub = commands.getOrDefault(arguments.get(0), helpSubCommand);
    return sub.execute(sender, cmd, alias, arguments);
  }
}
