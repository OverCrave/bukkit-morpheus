package io.github.commandertvis.morpheus.command

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utility.hasEnoughArgs
import io.github.commandertvis.morpheus.utility.placeholder
import io.github.commandertvis.morpheus.utility.sendFormatMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

/**
 * The singleton that stores the executor for the main plugin's command.
 */
object MorpheusCommand : CommandExecutor, TabCompleter {

  init {

    with(plugin.getCommand("morpheus")) {
      executor = this@MorpheusCommand
      tabCompleter = this@MorpheusCommand
    }

  }

  override fun onTabComplete(
    sender: CommandSender,
    command: Command,
    alias: String,
    args: Array<out String>
  ): MutableList<String>? {
    if (args.size <= 1) return mutableListOf("toggle")
    return null
  }

  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (!sender.hasPermission("morpheus.control")) {
      sender.sendFormatMessage(Configuration.Messages.noPermission)
      return true
    }

    if (args.hasEnoughArgs(1, sender)) return true

    when (args.first().toLowerCase()) {
      "toggle" -> {
        plugin.toggled = !plugin.toggled
        if (plugin.toggled) {
          sender.sendFormatMessage(Configuration.Messages.enabled)
        } else sender.sendFormatMessage(Configuration.Messages.disabled)
      }
      else -> {
        sender.sendFormatMessage(
            Configuration
                .Messages
                .default
                .placeholder("version", plugin.description.version)
        )
      }
    }
    return true
  }
}