# ZombifiedPiglinPatch

A small Fabric mod for Minecraft 26.3 that undoes two changes to zombified piglins.

## What it does

**Always drop XP.** Since 1.21.5, zombified piglins only drop XP when a player (or a tamed wolf) recently hit them. This mod brings the old behavior back: they drop their normal XP no matter how they die, including minecart/entity cramming, fall damage, fire and lava. XP amounts are unchanged, and the `mob_drops` gamerule still applies.

**No spawn spears.** Zombified piglins no longer spawn with spears. A spear rolled during equipment generation is replaced with the usual golden sword.

Spears that are added on purpose still work: ones given with commands or NBT, ones a piglin picks up, and ones it already carries when a world loads. This keeps looting-spear farms intact.

Other mobs are not touched.

## Requirements

- Minecraft 26.3
- Fabric Loader 0.20.1 or newer
- [Fabric API](https://modrinth.com/mod/fabric-api)

The mod is server-side only. Players don't need it on their client.

## Installation

Drop the jar into the `mods` folder of your server (or your instance, for singleplayer) and start the game.

## Building

```
./gradlew build
```

The jar ends up in `build/libs/`. Needs JDK 25.

## How it works

- A mixin on `LivingEntity#isAlwaysExperienceDropper` makes zombified piglins count as always-XP droppers.
- A mixin on `ZombifiedPiglin#populateDefaultEquipmentSlots` swaps a rolled spear for a golden sword.

There are no tick handlers, event listeners or entity scans.

## Credits & Licence

Copyright (c) 2026 [DungeonHD](https://github.com/DungeonHD)

This work is licensed under the GPL-3.0 Licence.
