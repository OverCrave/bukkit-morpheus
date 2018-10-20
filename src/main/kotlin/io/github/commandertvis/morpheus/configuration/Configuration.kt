package io.github.commandertvis.morpheus.configuration

/**
 * The configuration object
 */
object Configuration {
  /**
   * Should plugin set bed spawn after clicking by the bed at night
   */
  var setBedSpawn by Property<Boolean> { "set-bed-spawn" }
  /**
   * Share of players in bed
   */
  var shareOfPlayers by Property<Float> { "share-of-players" }

  /**
   * Messages section
   */
  object Messages {
    /**
     * This message is showed when player sets his spawnpoint using plugin
     */
    var setSpawn by Property<String> { "messages.set-spawn" }
    /**
     * This message is showed when player hasn't permission to access the command
     */
    var noPermission by Property<String> { "messages.no-permission" }
    /**
     * This message is showed when night is skipped by Morpheus
     */
    var goodMorning by Property<String> { "messages.good-morning" }
    /**
     * This message is showed when player goes to bed
     */
    var wentToBed by Property<String> { "messages.went-to-bed" }
    /**
     * This message is showed when player leaves bed
     */
    var leftBed by Property<String> { "messages.left-bed" }

    /**
     * Commands section
     */
    object Commands {
      /**
       * This message is showed when player runs /morpheus command
       */
      var default by Property<String> { "messages.commands.default" }
      /**
       * This message is showed when player runs /morpheus toggle command and turns sleep voting on
       */
      var enabled by Property<String> { "messages.commands.enabled" }
      /**
       * This message is showed when player runs /morpheus toggle command and turns sleep voting off
       */
      var disabled by Property<String> { "messages.commands.disabled" }
    }
  }
}