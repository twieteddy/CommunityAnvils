package io.github.twieteddy.communityanvils.enums;

public enum Message {

  PREFIX("prefix"),
  NO_PERMISSION("messages.no-permission"),
  SENDER_NOT_PLAYER("messages.sender-not-player"),
  ABORTED("messages.aborted"),
  NOTHING_TO_ABORT("messages.nothing-to-abort"),
  MODE_ALREADY_SET("messages.mode-already-set"),
  ITEM_REPAIRED("messages.item-repaired"),
  ITEM_NOT_REPAIRABLE("messages.item-not-repairable"),
  CREATING_ABORTED("messages.creating-aborted"),
  CREATING_STARTED("messages.creating-started"),
  DELETING_STARTED("messages.deleting-started"),
  DELETING_ABORTED("messages.deleting-aborted"),
  ANVIL_CREATED("messages.anvil-created"),
  ANVIL_DELETED("messages.anvil-deleted"),
  BLOCK_NOT_ANVIL("messages.block-not-anvil"),
  BLOCK_ALREADY_COMMUNITY_ANVIL("messages.block-already-community-anvil"),
  BLOCK_NOT_COMMUNITY_ANVIL("messages.block-not-community-anvil");

  String node;

  Message(String text) {
    node = text;
  }

  @Override
  public String toString() {
    return node;
  }
}
