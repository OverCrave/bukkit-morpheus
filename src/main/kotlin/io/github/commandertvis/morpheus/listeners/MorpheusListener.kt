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
            plugin.sleepers++
            val ratio: Float = plugin.sleepers.toFloat() / plugin.world.players.size
            Bukkit.broadcastMessage(plugin.configuration.getString("went-to-bed-message").replace("%player%", event.player.name).replace("%sleeping%", (ratio * 100).toInt().toString()).colorize())

            if(ratio >= plugin.configuration.getDouble("share-of-players")) {
                plugin.world.time = 0
                plugin.sleepers = 0
                Bukkit.broadcastMessage(plugin.configuration.getString("good-morning-message").colorize())
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
                plugin.sleepers--
                Bukkit.broadcastMessage(plugin.configuration.getString("left-bed-message").replace("%player%", event.player.name).replace("%sleeping%", (plugin.sleepers.toFloat() / plugin.world.players.size * 100).toInt().toString()).colorize())
            }
        }

    }

}