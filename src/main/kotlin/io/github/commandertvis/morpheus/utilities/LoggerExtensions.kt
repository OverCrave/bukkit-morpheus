package io.github.commandertvis.morpheus.utilities

import io.github.commandertvis.morpheus.PREFIX
import java.util.logging.Logger
import io.github.commandertvis.morpheus.plugin

fun Logger.infoWithPrefix(message: String?) {
    this.info("$PREFIX $message")
}

fun Logger.warnWithPrefix(message: String?) {
    this.warning("$PREFIX $message")
}