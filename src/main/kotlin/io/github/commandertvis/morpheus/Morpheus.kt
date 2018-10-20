package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.command.MorpheusCommand
import io.github.commandertvis.morpheus.listener.MorpheusListener
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin

/**
 * The internal instance of the plugin
 */
internal lateinit var plugin: Morpheus

/**
 * The main class of the plugin
 */
class Morpheus : JavaPlugin() {

  /**
   * It stores if the skipping night works
   */
  var toggled: Boolean = true
  /**
   * The key that should be active during a skipping right now
   */
  var skippingNow: Boolean = false
  /**
   * The quantity of players that sleep
   */
  var sleepers: Int = 0
  /**
   * The overworld
   */
  lateinit var world: World

  override fun onEnable() {
    plugin = this
    world = Bukkit.getWorlds()[0]
    saveDefaultConfig()
    registerCommand()
    registerListener()
  }

  /**
   * The method to register plugin's command
   */
  private fun registerCommand() {
    MorpheusCommand
  }

  /**
   * The method to register plugin's listener
   */
  private fun registerListener() {
    MorpheusListener
  }

}