package io.github.commandertvis.morpheus.utility

import org.bukkit.command.CommandSender

/**
 * This function sends message and parses color codes before
 * @message message to format and send
 */
fun CommandSender.sendFormatMessage(message: String) = sendMessage(message.color())