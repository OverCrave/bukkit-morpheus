package io.github.commandertvis.morpheus.utilities

import org.bukkit.ChatColor

fun String.colorize(): String = ChatColor.translateAlternateColorCodes('&', this)

fun String.placeholder(key: String, value: Any): String = replace("%$key%", value.toString())