package io.github.commandertvis.morpheus.configuration

/**
 * The configuration object.
 * @property shareOfPlayers Share of players in bed.
 */
object Configuration {
  var shareOfPlayers by Property<Float> { "share-of-players" }

  /**
   * Messages section.
   * @property noPermission This message is showed when player hasn't permission to access the command.
   * @property goodMorning This message is showed when night is skipped by Morpheus.
   * @property wentToBed This message is showed when player goes to bed.
   * @property leftBed This message is showed when player leaves bed.
   */
  object Messages {
    var noPermission by Property<String> { "messages.no-permission" }
    var goodMorning by Property<String> { "messages.good-morning" }
    var wentToBed by Property<String> { "messages.went-to-bed" }
    var leftBed by Property<String> { "messages.left-bed" }

    /**
     * Commands section.
     * @property default This message is showed when player runs /morpheus command.
     * @property enabled This message is showed when player runs /morpheus toggle command and turns sleep voting on.
     * @property disabled This message is showed when player runs /morpheus toggle command and turns sleep voting off.
     */
    object Commands {
      var default by Property<String> { "messages.commands.default" }
      var enabled by Property<String> { "messages.commands.enabled" }
      var disabled by Property<String> { "messages.commands.disabled" }
    }
  }
}