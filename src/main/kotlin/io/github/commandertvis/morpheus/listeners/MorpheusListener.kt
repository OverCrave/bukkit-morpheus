package io.github.commandertvis.morpheus.listeners

import io.github.commandertvis.morpheus.utilities.colorize
import io.github.commandertvis.morpheus.plugin
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

object MorpheusListener : Listener{

    @EventHandler(priority = EventPriority.HIGH)
    fun onPlayerEntersBed(event: PlayerBedEnterEvent) {

        if(plugin.toggleMorpheus) {
            plugin.sleepers ++
            val ratio: Float = plugin.sleepers.toFloat() / plugin.world.players.size
            Bukkit.broadcastMessage("&f${event.player.name}&7 went to bed (${(ratio * 100).toInt()}% sleeping)".colorize())

            if(ratio >= plugin.configuration.getDouble("share-of-players")) {
                plugin.world.time = 0
                plugin.sleepers = 0
                Bukkit.broadcastMessage("&6Good morning! The night was skipped".colorize())
            }
            plugin.isSkippingNow = true
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onPlayerLeavesBed(event: PlayerBedLeaveEvent) {

        if(plugin.toggleMorpheus) {
            if(plugin.isSkippingNow) {
                plugin.isSkippingNow = false
            } else {
                plugin.sleepers --
                Bukkit.broadcastMessage("&f${event.player.name}&7 left the bed (${(plugin.sleepers / plugin.world.players.size * 100)}% sleeping)".colorize())
            }
        }

    }

}