package io.github.commandertvis.morpheus.configuration

import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utilities.colorize

/**
 * The configuration object.
 * @property shareOfPlayers Share of players in bed.
 */
object Configuration {
  var shareOfPlayers: Float = 0.0f

  /**
   * Messages section.
   * @property noPermission This message is showed when player hasn't permission to access the command.
   * @property goodMorning This message is showed when night is skipped by Morpheus.
   * @property wentToBed This message is showed when player goes to bed.
   * @property leftBed This message is showed when player leaves bed.
   */
  object Messages {
    lateinit var noPermission: String
    lateinit var goodMorning: String
    lateinit var wentToBed: String
    lateinit var leftBed: String

    /**
     * Commands section.
     * @property default This message is showed when player runs /morpheus command.
     * @property enabled This message is showed when player runs /morpheus toggle command and turns sleep voting on.
     * @property disabled This message is showed when player runs /morpheus toggle command and turns sleep voting off.
     */
    object Commands {
      lateinit var default: String
      lateinit var enabled: String
      lateinit var disabled: String
    }
  }

  /**
   * The method to load the configuration fields.
   */
  fun load() {
    with(plugin.configuration) {
      shareOfPlayers = getInt("share-of-players").toFloat() / 100f

      with(getConfigurationSection("messages")) {
        Messages.noPermission = getString("no-permission").colorize()
        Messages.goodMorning = getString("good-morning").colorize()
        Messages.wentToBed = getString("went-to-bed").colorize()
        Messages.leftBed = getString("left-bed").colorize()

        with(getConfigurationSection("commands")) {
          Messages.Commands.default = getString("default").colorize()
          Messages.Commands.enabled = getString("enabled").colorize()
          Messages.Commands.disabled = getString("disabled").colorize()
        }
      }
    }
  }
}