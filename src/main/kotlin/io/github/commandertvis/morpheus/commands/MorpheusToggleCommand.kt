package io.github.commandertvis.morpheus.commands

import io.github.commandertvis.morpheus.utilities.parseColor
import io.github.commandertvis.morpheus.Morpheus.Companion.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object MorpheusToggleCommand : CommandExecutor {
    override fun onCommand(commandSender: CommandSender?, command: Command?, label: String?, arguments: Array<out String>?): Boolean {
        plugin.isMorpheusEnabled = !plugin.isMorpheusEnabled
        if(plugin.isMorpheusEnabled) {
            commandSender?.sendMessage("&7&lSleep voting is now activated".parseColor())
        } else commandSender?.sendMessage("&7&lSleep voting is now inactivated".parseColor())
        return true
    }
}