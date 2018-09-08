package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.commands.MorpheusCommand
import io.github.commandertvis.morpheus.listeners.MorpheusListener
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

internal lateinit var plugin: Morpheus

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

    registerCommands()
    registerListeners()
  }

  private fun registerCommands() {
    getCommand("morpheus").executor = MorpheusCommand
  }

  private fun registerListeners() {
    Bukkit.getPluginManager().registerEvents(MorpheusListener, this)
  }
}