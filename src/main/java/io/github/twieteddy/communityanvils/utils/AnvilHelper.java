package io.github.twieteddy.communityanvils;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

/**
 * Manages the config for community anvils
 */
public class Anvils {

  private static Anvils communityAnvilsManager = new Anvils();
  private static CopyOnWriteArraySet<Location> anvilLocationsSet = new CopyOnWriteArraySet<>();


  private Anvils() {
    anvilLocationsSet = new CopyOnWriteArraySet<>();
  }


  @Contract(pure = true)
  public static Anvils getInstance() {
    return communityAnvilsManager;
  }


  public static void reload() {
    communityAnvilsManager = new Anvils();
  }


  public Set<Location> getAnvilLocations() {
    return anvilLocationsSet;
  }


  public void addCommunityAnvilAt(Location anvilLocation)  {
    if (!anvilLocationsSet.add(anvilLocation)) {

    }
  }

  public void deleteCommunityAnvilAt(Location anvilLocation) {
    if (!anvilLocationsSet.remove(anvilLocation)) {

    }
  }


  public boolean isCommunityAnvil(Block possibleAnvil) {
    if (possibleAnvil == null) {
      return false;
    }

    if (possibleAnvil.getType() == Material.ANVIL
      || possibleAnvil.getType() == Material.CHIPPED_ANVIL
      || possibleAnvil.getType() == Material.DAMAGED_ANVIL) {
      return true;
    } else {
      return false;
    }

    /*return CommunityAnvilsManager
        .getInstance()
        .getAnvilLocations()
        .contains(possibleAnvilLocation);*/
  }
}
