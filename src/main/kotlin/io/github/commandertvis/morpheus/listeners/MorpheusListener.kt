package io.github.commandertvis.morpheus.listeners

import io.github.commandertvis.morpheus.utilities.parseColor
import io.github.commandertvis.morpheus.Morpheus.Companion.plugin
import io.github.commandertvis.morpheus.utilities.infoWithPrefix
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

object MorpheusListener : Listener{

    @EventHandler(priority = EventPriority.HIGH)
    fun onPlayerEntersBed(event: PlayerBedEnterEvent) {

        if(plugin.isMorpheusEnabled) {
            plugin.sleepers ++
            val ratio: Float = plugin.sleepers.toFloat() / plugin.server.onlinePlayers.size
            Bukkit.broadcastMessage("&f${event.player.name}&7 went to bed (${(ratio * 100).toInt()}% sleeping)".parseColor())

            if(ratio >= 0.5) {
                plugin.world.time = 0
                Bukkit.broadcastMessage("&6Good morning! The night was skipped".parseColor())
                plugin.sleepers = 0
            }
            plugin.isSkippingNow = true
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onPlayerLeavesBed(event: PlayerBedLeaveEvent) {

        if(plugin.isMorpheusEnabled) {
            if(plugin.isSkippingNow) {
                plugin.isSkippingNow = false
            } else {
                plugin.sleepers--
                Bukkit.broadcastMessage("&f${event.player.name}&7 left the bed (${(plugin.sleepers / plugin.server.onlinePlayers.size * 100)}% sleeping)".parseColor())
            }
        }

    }

}