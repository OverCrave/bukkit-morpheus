package io.github.commandertvis.morpheus.command

import io.github.commandertvis.morpheus.configuration.Configuration
import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utility.colorize
import io.github.commandertvis.morpheus.utility.placeholder
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

/**
 * The singleton that stores the executor for the main plugin's command.
 */
object MorpheusCommand : CommandExecutor {

  /**
   * To register this command.
   */
  init {
    plugin.getCommand("morpheus").executor = MorpheusCommand
  }

  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (!sender.hasPermission("morpheus")) {
      sender.sendMessage(Configuration.Messages.noPermission.colorize())
      return true
    }

    if (args.isEmpty()) {
      sender.sendMessage(Configuration.Messages.Commands.default
          .colorize()
          .placeholder("version", plugin.description.version)
      )
      return true
    }

    when (args.first().toLowerCase()) {
      "toggle" -> {
        plugin.toggled = !plugin.toggled
        if (plugin.toggled) {
          sender.sendMessage(Configuration.Messages.Commands.enabled.colorize())
        } else sender.sendMessage(Configuration.Messages.Commands.disabled.colorize())
      }
    }
    return true
  }
}