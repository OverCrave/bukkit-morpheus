package io.github.commandertvis.morpheus.utilities

import org.bukkit.ChatColor

fun String.parseColor(): String = ChatColor.translateAlternateColorCodes('&', this)