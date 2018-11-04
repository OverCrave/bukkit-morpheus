package io.github.commandertvis.morpheus.configuration

import io.github.commandertvis.morpheus.plugin
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegates config.yml entries
 */
class Property<T>(
  /**
   * The name of property
   */
  val name: () -> String
) : ReadOnlyProperty<Any, T> {
  /**
   * Gets value from configuration
   */
  @Suppress("UNCHECKED_CAST")
  override fun getValue(thisRef: Any, property: KProperty<*>): T = plugin.config.get(name()) as T
}