package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.utilities.colorize

object Configuration {
  var shareOfPlayers: Float = 0.0f

  object Messages {
    lateinit var noPermission: String
    lateinit var goodMorning: String
    lateinit var wentToBed: String
    lateinit var leftBed: String

    object Commands {
      lateinit var default: String
      lateinit var enabled: String
      lateinit var disabled: String
    }
  }

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