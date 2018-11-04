# Morpheus

**Morpheus** is a plugin that ports a Forge mod with the same name. It skips night when more than half of players sleep. It's fully configurable and compatible with permissions. 

# Configuration

* `set-bed-spawn` &mdash; should plugin set bed spawn after clicking by the bed at night. 
* `share-of-players` &mdash; share of players for skipping night. 
* `messages: `
  * `set-spawn` &mdash; this message is showed when player sets his spawnpoint using plugin. 
  * `no-permission` &mdash; this message is showed when player hasn't permission to access the command. 
  * `good-morning` &mdash; this message is showed when night is skipped by Morpheus. 
  * `went-to-bed` &mdash; this message is showed when player goes to bed. 
  * `left-bed` &mdash; this message is showed when player leaves bed. 
  * `commands: `
  * `default` &mdash; this message is showed when player runs /morpheus command with one any unknown argument. 
  * `enabled` &mdash; this message is showed when player runs /morpheus toggle command and turns sleep voting on. 
  * `disabled` &mdash; this message is showed when player runs /morpheus toggle command and turns sleep voting off. 
  * `not-enough-args` &mdash; this message is showed when player runs /morpheus command without any arguments. 

Default `config.yml`: 

```yaml
set-bed-spawn: true
share-of-players: 0.5
messages:
  set-spawn: "&aBed spawn set"
  no-permission: "&4No permission"
  good-morning: "&6Good morning! The night was skipped"
  went-to-bed: "&f%player%&7 went to bed (%sleeping%% sleeping)"
  left-bed: "&f%player%&7 left the bed (%sleeping%% sleeping)"
  default: "&7You're running Morpheus %version%\n&7Commands:\n&7 — &f/morpheus toggle&7: toggle the plugin"
  enabled: "&aSleep voting is now activated"
  disabled: "&7Sleep voting is now inactivated"
  not-enough-args: "&4Not enough arguments"
```

# Permissions

* `morpheus.control`  &mdash; players having this permission can temporary turn off the plugin in an emergency situation. 

# Credits to

* [Commander Tvis](https://github.com/CommanderTvis), 
* [Mdashl](https://github.com/Mdashl), 
* [Morpheus mod](https://github.com/Quetzi/Morpheus), 
* Bukkit and Spigot teams.
