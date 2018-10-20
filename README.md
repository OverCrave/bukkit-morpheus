# Morpheus

**Morpheus** is a plugin that ports a Forge mod with the same name. It skips night when more than half of players sleep. Fully configurable and compatible with permissions. 

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
    * `default` &mdash; this message is showed when player runs /morpheus command. 
    * `enabled` &mdash; this message is showed when player runs /morpheus toggle command and turns sleep voting on. 
    * `disabled` &mdash; this message is showed when player runs /morpheus toggle command and turns sleep voting off. 

Default `config.yml`: 

```yaml
set-bed-spawn: true
share-of-players: 0.5
messages:
  set-spawn: "&7&lBed spawn set"
  no-permission: "&4No permission"
  good-morning: "&6Good morning! The night was skipped"
  went-to-bed: "&f%player%&7 went to bed (%sleeping%% sleeping)"
  left-bed: "&f%player%&7 left the bed (%sleeping%% sleeping)"
  commands:
    default: "&7&lYou're running Morpheus %version%\n&7Commands:\n&7 — &f/morpheus toggle&7: toggle the plugin"
    enabled: "&7&lSleep voting is now activated"
    disabled: "&7&lSleep voting is now inactivated"
```

# Permissions

* `morpheus` &mdash; allows to toggle sleep voting. 

# Credits to

* [Commander Tvis](https://github.com/CommanderTvis), 
* [Mdash](https://github.com/Hulumululululu), 
* [Morpheus mod](https://github.com/Quetzi/Morpheus), 
* Bukkit and Spigot teams.
