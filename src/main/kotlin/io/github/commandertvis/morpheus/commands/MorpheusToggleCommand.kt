package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusToggleCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        plugin.toggleMorpheus = !plugin.toggleMorpheus
        sender.sendMessage("&7&lSleep voting is now ${if (plugin.toggleMorpheus) "activated" else "inactivated"}")
        return true
    }
}