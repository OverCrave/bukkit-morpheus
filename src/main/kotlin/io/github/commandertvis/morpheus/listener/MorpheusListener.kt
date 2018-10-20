package io.github.commandertvis.morpheus.listener

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utility.colorize
import io.github.commandertvis.morpheus.utility.placeholder
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent
import kotlin.math.roundToInt

/**
 * The common event listener of the plugin.
 */
object MorpheusListener : Listener {

  /**
   * To register this listener.
   */
  init {
    Bukkit.getPluginManager().registerEvents(MorpheusListener, plugin)
  }

  /**
   * The handler to skip night when the enough of players are in bed.
   * @param event event object.
   */
  @EventHandler
  fun onPlayerBedEnter(event: PlayerBedEnterEvent) {

    if (!plugin.toggled) return

    plugin.sleepers++

    val ratio: Float = plugin.sleepers.toFloat() / plugin.world.players.size.toFloat()

    Bukkit.broadcastMessage(
        Configuration.Messages.wentToBed
            .colorize()
            .placeholder("player", event.player.name)
            .placeholder("sleeping", (ratio * 100).roundToInt().toString())
    )

    if (ratio >= Configuration.shareOfPlayers) {
      plugin.skippingNow = true
      plugin.world.time = 0
      plugin.sleepers = 0
      Bukkit.broadcastMessage(Configuration.Messages.goodMorning.colorize())
    }
  }

  /**
   * The handler not to skip night when players leave bed.
   * @param event an event object.
   */
  @EventHandler
  fun onPlayerBedLeave(event: PlayerBedLeaveEvent) {

    if (!plugin.toggled) return
    if (plugin.skippingNow) {
      plugin.skippingNow = false
      return
    }

    plugin.sleepers--

    Bukkit.broadcastMessage(
        Configuration.Messages.leftBed
            .colorize()
            .replace("%player%", event.player.name)
            .replace(
                "%sleeping%",
                (plugin.sleepers.toFloat() / plugin.world.players.size * 100).roundToInt().toString()
            )
    )

  }
}