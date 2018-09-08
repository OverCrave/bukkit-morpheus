package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.utilities.parseColor
import io.github.commandertvis.morpheus.Morpheus.Companion.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusCommand : CommandExecutor {
    override fun onCommand(commandSender: CommandSender?, command: Command?, label: String?, arguments: Array<out String>?): Boolean {
        commandSender?.sendMessage("&7&lYou're running Morpheus ${plugin.description.version}\n&7Available subcommand:\n&7 - &f/morpheustoggle&7: toggle to skip night voting".parseColor())
        return true
    }
}