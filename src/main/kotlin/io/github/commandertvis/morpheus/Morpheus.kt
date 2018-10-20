package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.command.MorpheusCommand
import io.github.commandertvis.morpheus.listener.MorpheusListener
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin

/**
 * The internal instance of the plugin.
 */
internal lateinit var plugin: Morpheus

/**
 * The main class of the plugin.
 * @property toggled It stores if the skipping night works.
 * @property skippingNow The key that should be active during a skipping right now.
 * @property sleepers Quantity of players that sleep.
 * @property world The world.
 */
class Morpheus : JavaPlugin() {

  var toggled: Boolean = true
  var skippingNow: Boolean = false
  var sleepers: Int = 0
  lateinit var world: World

  override fun onEnable() {
    plugin = this
    saveDefaultConfig()

    world = Bukkit.getWorld("world")
    registerCommand()
    registerListener()
  }

  private fun registerCommand() {
    MorpheusCommand
  }

  private fun registerListener() {
    MorpheusListener
  }

}