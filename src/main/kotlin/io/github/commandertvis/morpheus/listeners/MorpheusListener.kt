package io.github.commandertvis.morpheus.listeners

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utilities.placeholder
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

/**
 * The common event listener of the plugin.
 */
object MorpheusListener : Listener {
  /**
   * The handler to skip night when the enough of players are in bed.
   */
  @EventHandler
  fun onPlayerBedEnter(event: PlayerBedEnterEvent) {

    if (!plugin.toggled) return

    plugin.sleepers++

    val ratio: Float = plugin.sleepers.toFloat() / plugin.world.players.size.toFloat()

    Bukkit.broadcastMessage(
        Configuration.Messages.wentToBed.placeholder("player", event.player.name).placeholder(
            "sleeping", (ratio * 100).toInt()
        )
    )

    if (ratio >= Configuration.shareOfPlayers) {
      plugin.skippingNow = true
      plugin.world.time = 0
      plugin.sleepers = 0
      plugin.skippingNow = true
      Bukkit.broadcastMessage(Configuration.Messages.goodMorning)
    }
  }

  /**
   * The handler not to skip night when players leave bed.
   * @param event an event object.
   */
  @EventHandler
  fun onPlayerBedLeave(event: PlayerBedLeaveEvent) {

    if (!plugin.toggled) return
    if (plugin.skippingNow) return

    plugin.sleepers--
    Bukkit.broadcastMessage(
        Configuration.Messages.leftBed.placeholder("player", event.player.name).placeholder(
            "sleeping", (plugin.sleepers.toFloat() / plugin.world.players.size * 100).toInt()
        )
    )

  }
}