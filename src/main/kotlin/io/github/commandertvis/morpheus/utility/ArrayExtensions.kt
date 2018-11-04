package io.github.commandertvis.morpheus.utility

import io.github.commandertvis.morpheus.configuration.Configuration
import org.bukkit.command.CommandSender

/**
 * This function checks the arguments array if it contains enough elements. If not it sends a message to the command sender
 * @param neededSize needed length of the array
 * @param sender the command sender to inform
 * @return true if array contains enough elements
 */
fun Array<out String>.hasEnoughArgs(neededSize: Int, sender: CommandSender? = null): Boolean {
  val state: Boolean = size < neededSize
  if (state) sender?.sendFormatMessage(Configuration.Messages.notEnoughArgs)
  return state
}