package io.github.twieteddy.communityanvils.utils;

import io.github.twieteddy.communityanvils.CommunityAnvils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class AnvilHelper {
/*
  private final List<Location> anvilLocations = new ArrayList<>();
  private final List<Material> anvilMaterials = new ArrayList<>();
  private final Logger logger;
  private final File anvilsConfigFile;
  private final CommunityAnvils plugin;
  private FileConfiguration anvilsConfig;

  private static class Strings {

    static final String FILENAME = "anvils.yml";
    static final String SECTION = "locations";
    static final String ANVIL_ADDED_AT = "Anvil added at %f, %f, %f";
    static final String MALFORMED_ENTRY = "Malformed entry: %s";
  }

  public AnvilHelper(Config config) {

    this.plugin = config.getPlugin();
    this.logger = config.getLogger();

    anvilMaterials.add(Material.ANVIL);
    anvilMaterials.add(Material.CHIPPED_ANVIL);
    anvilMaterials.add(Material.DAMAGED_ANVIL);

    anvilsConfigFile = new File(config.getPlugin().getDataFolder(), Strings.FILENAME);
    reload();
  }

  private void reload() {
    if (!anvilsConfigFile.exists()) {
      plugin.saveResource(Strings.FILENAME, true);
    }

    if (!isConfigValid()) {
      return;
    }

    List locationObjects = anvilsConfig.getList(Strings.SECTION);
    if (locationObjects == null) {
      anvilsConfig.set(Strings.SECTION, new ArrayList());
      save();
    }

    for (Object locationObject : Objects.requireNonNull(locationObjects)) {
      if (locationObject instanceof Location) {
        Location location = (Location) locationObject;
        anvilLocations.add(location);
        logger.info(String.format(
            Strings.ANVIL_ADDED_AT,
            location.getX(),
            location.getY(),
            location.getZ()));
      } else {
        logger.warning(String.format(Strings.MALFORMED_ENTRY, locationObject.toString()));
      }
    }
  }

  private boolean isConfigValid() {
    anvilsConfig = YamlConfiguration.loadConfiguration(anvilsConfigFile);
    return anvilsConfig.getList(Strings.SECTION) != null;
  }

  private void save() {
    Objects.requireNonNull(anvilsConfig.getRoot()).set(Strings.SECTION, anvilLocations);
    try {
      anvilsConfig.save(anvilsConfigFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Location> getAnvilLocations() {
    return anvilLocations;
  }

  public void addAnvil(Location anvilLocation) {
    anvilLocations.add(anvilLocation);
    save();
  }

  public void deleteAnvil(Location anvilLocation) {
    anvilLocations.remove(anvilLocation);
    save();
  }

  public boolean isBlockAnAnvil(Block possibleAnvil) {
    return anvilMaterials.contains(possibleAnvil.getType());
  }

  public boolean isCommunityAnvil(Block possibleAnvil) {
    return possibleAnvil != null && getAnvilLocations().contains(possibleAnvil.getLocation());
  }

     */
}
