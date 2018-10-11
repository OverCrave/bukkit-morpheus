package io.github.commandertvis.morpheus.utilities

import org.bukkit.ChatColor

/**
 * Function for formatting messages by Bukkit color codes.
 * @return string where & color codes are replaced with \u00A7 color codes.
 */
fun String.colorize(): String = ChatColor.translateAlternateColorCodes('&', this)

/**
 * Replaces placeholders with the real value.
 * @param key placeholder key like %version%.
 * @param value real value like 0.15.
 * @return string where all the keys are replaced with the value.
 */
fun String.placeholder(key: String, value: Any): String = replace("%$key%", value.toString())