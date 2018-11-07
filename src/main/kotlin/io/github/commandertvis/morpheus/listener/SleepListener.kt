package io.github.commandertvis.morpheus.listener

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utility.color
import io.github.commandertvis.morpheus.utility.placeholder
import io.github.commandertvis.morpheus.utility.sendFormatMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.bukkit.Bukkit
import org.bukkit.Statistic
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent
import kotlin.math.roundToInt

/**
 * The common event listener of the plugin
 */
object SleepListener : Listener {

  init {
    Bukkit.getPluginManager().registerEvents(SleepListener, plugin)
  }

  /**
   * The handler to skip night when the enough of players are in bed
   * @param event event object
   */
  @EventHandler(priority = EventPriority.HIGHEST)
  fun onPlayerBedEnter(event: PlayerBedEnterEvent) {

    val player = event.player
    if (!plugin.toggled) return

    plugin.skippingNow = false
    plugin.sleepers++

    player.setStatistic(Statistic.TIME_SINCE_REST, 0)

    val ratio: Float = plugin.sleepers.toFloat() / plugin.world.players.size.toFloat()

    Bukkit.broadcastMessage(
        Configuration.Messages.wentToBed
            .color()
            .placeholder("player", event.player.name)
            .placeholder(
                "sleeping",
                (ratio * 100).roundToInt().toString()
            )
    )

    if (ratio >= Configuration.shareOfPlayers) {
      plugin.skippingNow = true

      GlobalScope.launch {
        while (plugin.world.time > 20) {
          plugin.world.time += 10
          Thread.sleep(1)
        }
        Bukkit.broadcastMessage(Configuration.Messages.goodMorning.color())

        if (Configuration.informWithTitle) {
          for (i in Bukkit.getOnlinePlayers())
            i.sendTitle(Configuration.Messages.goodMorning.color(), "", 5, 15, 5)
        }
      }

      plugin.sleepers = 0

    }
  }

  /**
   * The handler not to skip night when players leave bed
   * @param event an event object
   */
  @EventHandler(priority = EventPriority.HIGHEST)
  fun onPlayerBedLeave(event: PlayerBedLeaveEvent) {

    val player = event.player
    if (!plugin.toggled) return
    if (plugin.skippingNow) {
      if (Configuration.setBedSpawn) {
        player.bedSpawnLocation = player.location
        player.sendFormatMessage(Configuration.Messages.setSpawn)
      }
      return
    }

    plugin.sleepers--

    Bukkit.broadcastMessage(
        Configuration.Messages.leftBed
            .color()
            .placeholder("player", player.name)
            .placeholder(
                "sleeping",
                (plugin.sleepers.toFloat() / plugin.world.players.size * 100).roundToInt().toString()
            )
    )

  }

}