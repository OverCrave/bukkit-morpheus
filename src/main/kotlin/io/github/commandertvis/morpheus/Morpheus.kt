package io.github.commandertvis.morpheus

import io.github.commandertvis.morpheus.commands.MorpheusCommand
import io.github.commandertvis.morpheus.commands.MorpheusToggleCommand
import io.github.commandertvis.morpheus.listeners.MorpheusListener
import io.github.commandertvis.morpheus.utilities.infoWithPrefix
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class Morpheus : JavaPlugin() {

    companion object {
        lateinit var plugin: Morpheus
    }

    var isMorpheusEnabled = true

    var isSkippingNow = false

    val console: Logger? = Bukkit.getLogger()

    private val pluginManager = Bukkit.getPluginManager()

    val pluginPrefix = "[Morpheus]"

    var sleepers: Int = 0

    lateinit var world: World

    lateinit var pluginConfig: FileConfiguration

    override fun onEnable() {

        plugin = this

        this.world = Bukkit.getWorld("world")

        this.getCommand("morpheus").executor = MorpheusCommand
        this.getCommand("morpheustoggle").executor = MorpheusToggleCommand

        this.defaultConfig()

        this.pluginManager.registerEvents(MorpheusListener, this)

        this.console?.infoWithPrefix("hello world")

    }

    override fun onDisable() {

        this.console?.infoWithPrefix("bye bye world")

    }

    private fun defaultConfig() {
        this.saveDefaultConfig()
        this.config
    }

}