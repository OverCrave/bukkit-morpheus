package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.utilities.colorize
import io.github.commandertvis.morpheus.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.hasPermission("morpheus.command")) {
            sender.sendMessage(plugin.configuration.getString("morpheus-command-message").replace("\\n","\n").replace("%version%",plugin.description.version).colorize())
        }
        else sender.sendMessage(plugin.configuration.getString("no-permission-message").colorize())
        return true
    }
}