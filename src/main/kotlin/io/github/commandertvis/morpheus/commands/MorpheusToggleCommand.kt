package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.plugin
import io.github.commandertvis.morpheus.utilities.colorize
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusToggleCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.hasPermission("morpheus.toggle")) {
            plugin.toggleMorpheus = !plugin.toggleMorpheus
            sender.sendMessage("${plugin.configuration.getString("sleep-voting-is")} ${if (plugin.toggleMorpheus) plugin.configuration.getString("activated") else plugin.configuration.getString("inactivated")}")
        } else sender.sendMessage(plugin.configuration.getString("no-permission-message").colorize())
        return true
    }
}