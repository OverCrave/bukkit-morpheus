package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utilities.placeholder
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

/**
 * The singleton that stores the executor for the main plugin's command.
 */
object MorpheusCommand : CommandExecutor {
  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (!sender.hasPermission("morpheus")) {
      sender.sendMessage(Configuration.Messages.noPermission)
      return true
    }

    if (args.isEmpty()) {
      sender.sendMessage(Configuration.Messages.Commands.default.placeholder(
          "version",
          plugin.description.version)
      )
      return true
    }

    when (args.first().toLowerCase()) {
      "toggle" -> {
        plugin.toggled = !plugin.toggled
        if (plugin.toggled) {
          sender.sendMessage(Configuration.Messages.Commands.enabled)
        } else sender.sendMessage(Configuration.Messages.Commands.disabled)
      }
    }
    return true
  }
}