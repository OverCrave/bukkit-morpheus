package io.github.commandertvis.morpheus.utilities

import java.util.logging.Logger
import io.github.commandertvis.morpheus.Morpheus.Companion.plugin

fun Logger.infoWithPrefix(message: String?) {
    this.info("${plugin.pluginPrefix} $message")
}

fun Logger.warnWithPrefix(message: String?) {
    this.warning("${plugin.pluginPrefix} $message")
}