package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.commands.MorpheusCommand
import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.listeners.MorpheusListener
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
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
 * @property world The main world.
 * @property configuration The configuration object.
 */
class Morpheus : JavaPlugin() {

  var toggled: Boolean = true

  var skippingNow: Boolean = false

  var sleepers: Int = 0

  lateinit var world: World

  lateinit var configuration: FileConfiguration

  override fun onEnable() {
    plugin = this

    saveDefaultConfig()
    configuration = config
    Configuration.load()

    world = Bukkit.getWorld("world")

    getCommand("morpheus").executor = MorpheusCommand
    Bukkit.getPluginManager().registerEvents(MorpheusListener, this)
  }

}