package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.utilities.colorize
import io.github.commandertvis.morpheus.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage((
            "&7&lYou're running Morpheus ${plugin.description.version}\n" +
            "&7Available subcommand:\n" +
            "&7 - &f/morpheustoggle&7: toggle to skip night voting").colorize()
        )
        return true
    }
}