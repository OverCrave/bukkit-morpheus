package io.github.commandertvis.morpheus.configuration

import io.github.commandertvis.morpheus.plugin
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegates config.yml entries.
 */
class Property<T>(
  val name: () -> String
) : ReadWriteProperty<Any, T> {
  /**
   * Gets value from configuration.
   */
  @Suppress("UNCHECKED_CAST")
  override fun getValue(thisRef: Any, property: KProperty<*>): T = plugin.config.get(name()) as T

  /**
   * Sets value into configuration.
   */
  override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
    plugin.config.set(name(), value)
    plugin.saveConfig()
  }
}