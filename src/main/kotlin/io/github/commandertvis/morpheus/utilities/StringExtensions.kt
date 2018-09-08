package io.github.commandertvis.morpheus.utilities

import org.bukkit.ChatColor

fun String.colorize(): String = ChatColor.translateAlternateColorCodes('&', this)