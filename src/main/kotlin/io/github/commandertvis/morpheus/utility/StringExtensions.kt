package io.github.commandertvis.morpheus.utility

import org.bukkit.ChatColor

/**
 * Function for formatting messages by Bukkit color codes
 * @return string where & color codes are replaced with \u00A7 color codes
 */
fun String.color(): String = ChatColor.translateAlternateColorCodes('&', this)

/**
 * Function to replace %placeholders% with values
 * @param key key of the placeholder
 * @param value value to replace with
 * @return string where all the placeholders with the values
 */
fun String.placeholder(key: String, value: Any): String = this.replace("%$key%", value.toString())