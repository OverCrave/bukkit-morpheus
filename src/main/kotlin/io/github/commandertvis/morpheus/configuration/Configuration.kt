package io.github.commandertvis.morpheus.configuration

/**
 * The configuration object
 */
object Configuration {

  /**
   * Should plugin set bed spawn after clicking by the bed at night
   */
  val setBedSpawn by Property<Boolean> { "set-bed-spawn" }
  /**
   * Share of players in bed
   */
  val shareOfPlayers by Property<Float> { "share-of-players" }
  /**
   * Messages section
   */

  object Messages {

    /**
     * This message is showed when player sets his spawnpoint using plugin
     */
    val setSpawn by Property<String> { "messages.set-spawn" }
    /**
     * This message is showed when player hasn't permission to access the command
     */
    val noPermission by Property<String> { "messages.no-permission" }
    /**
     * This message is showed when night is skipped by Morpheus
     */
    val goodMorning by Property<String> { "messages.good-morning" }
    /**
     * This message is showed when player goes to bed
     */
    val wentToBed by Property<String> { "messages.went-to-bed" }
    /**
     * This message is showed when player leaves bed
     */
    val leftBed by Property<String> { "messages.left-bed" }
    /**
     * This message is showed when player runs /morpheus command
     */
    val default by Property<String> { "messages.default" }
    /**
     * This message is showed when player runs /morpheus command with one any unknown argument
     */
    val enabled by Property<String> { "messages.enabled" }
    /**
     * This message is showed when player runs /morpheus toggle command and turns sleep voting off
     */
    val disabled by Property<String> { "messages.disabled" }
    /**
     * This message is showed when player runs /morpheus command without any arguments
     */
    val notEnoughArgs by Property<String> { "messages.not-enough-args" }

  }

}