package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.commands.MorpheusCommand
import io.github.commandertvis.morpheus.commands.MorpheusToggleCommand
import io.github.commandertvis.morpheus.listeners.MorpheusListener
import io.github.commandertvis.morpheus.utilities.infoWithPrefix
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.util.logging.Logger

const val PREFIX: String = "[Morpheus]"

internal lateinit var plugin: Morpheus

class Morpheus : JavaPlugin() {

    var toggleMorpheus = true

    var isSkippingNow = false

    private val pluginLogger: Logger = Bukkit.getLogger()

    private val pluginManager = Bukkit.getPluginManager()

    var sleepers: Int = 0

    lateinit var world: World

    lateinit var configuration: FileConfiguration

    override fun onEnable() {

        plugin = this

        this.world = Bukkit.getWorld("world")

        this.getCommand("morpheus").executor = MorpheusCommand
        this.getCommand("morpheustoggle").executor = MorpheusToggleCommand

        this.defaultConfig()

        this.pluginManager.registerEvents(MorpheusListener, this)

        this.pluginLogger.infoWithPrefix("hello world")

    }

    override fun onDisable() {

        this.pluginLogger.infoWithPrefix("bye bye world")

    }

    private fun defaultConfig() {
        this.saveDefaultConfig()
        this.configuration = YamlConfiguration.loadConfiguration(File(this.dataFolder, "config.yml"))
        this.configuration.addDefault("share-of-players", "0.5")
        this.configuration.addDefault("no-permission-message", "'&4No permission'")
        this.configuration.addDefault("good-morning-message", "'&6Good morning! The night was skipped'")
        this.configuration.addDefault("sleep-voting-is", "'&7&lSleep voting is now'")
        this.configuration.addDefault("activated", "'activated'")
        this.configuration.addDefault("inactivated", "'inactivated'")
    }

}