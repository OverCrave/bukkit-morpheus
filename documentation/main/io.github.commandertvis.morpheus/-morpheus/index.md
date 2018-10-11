[main](../../index.md) / [io.github.commandertvis.morpheus](../index.md) / [Morpheus](./index.md)

# Morpheus

`class Morpheus : JavaPlugin`

The main class of the plugin.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Morpheus()`<br>The main class of the plugin. |

### Properties

| Name | Summary |
|---|---|
| [configuration](configuration.md) | `lateinit var configuration: FileConfiguration`<br>The configuration object. |
| [skippingNow](skipping-now.md) | `var skippingNow: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The key that should be active during a skipping right now. |
| [sleepers](sleepers.md) | `var sleepers: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Quantity of players that sleep. |
| [toggled](toggled.md) | `var toggled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>It stores if the skipping night works. |
| [world](world.md) | `lateinit var world: World`<br>The main world. |

### Functions

| Name | Summary |
|---|---|
| [onEnable](on-enable.md) | `fun onEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
