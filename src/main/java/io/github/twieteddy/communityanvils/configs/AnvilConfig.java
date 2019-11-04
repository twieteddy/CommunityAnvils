package io.github.twieteddy.communityanvils.configs;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import io.github.twieteddy.communityanvils.exceptions.BlockAlreadyCommunityAnvilException;
import io.github.twieteddy.communityanvils.exceptions.BlockNotAnvilException;
import io.github.twieteddy.communityanvils.exceptions.BlockNotCommunityAnvilException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;

public class AnvilConfig implements Config {

  private final CommunityAnvils plugin;
  private final Logger logger;
  private final List<Block> anvilLocations;
  private final File file;

  public AnvilConfig(CommunityAnvils plugin) {
    this.plugin = plugin;
    this.logger = plugin.getLogger();
    this.anvilLocations = new ArrayList<>();
    this.file = new File(plugin.getDataFolder(), "anvils.yml");

    reload();
  }

  @Override
  public void reload() {
    if (!file.exists()) {
      plugin.saveResource("anvils.yml", true);
    }


  }

  public void addAnvil(Block block)
      throws BlockAlreadyCommunityAnvilException, BlockNotAnvilException {
    if (anvilLocations.contains(block)) {
      throw new BlockAlreadyCommunityAnvilException();
    }

    Material type = block.getType();
    if (!(type == Material.ANVIL
      || type == Material.CHIPPED_ANVIL
      || type == Material.DAMAGED_ANVIL)) {
      throw new BlockNotAnvilException();
    }

    anvilLocations.add(block);
  }

  public void deleteAnvil(Block block) throws BlockNotCommunityAnvilException {
    anvilLocations.remove(block);
  }

  public boolean isCommunityAnvil(Block block) {
    return anvilLocations.contains(block);
  }

  private void save() {
    YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
  }
}
