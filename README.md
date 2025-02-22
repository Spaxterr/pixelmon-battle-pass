PixelTaskTypes is a Spigot plugin developed for Arclight servers, enabling integration of Pixelmon specific tasks and events for [LMBishop's Quests plugin](https://github.com/LMBishop/Quests). With this plugin, server owners can create endless combinations of engaging and challenging quests for their Pixelmon servers.
## Features
* Seamless integration with Pixelmon and LMBishop's Quests
* Support for multiple task types, including catching, defeating, evolving and hatching Pokémon.
* Highly customizable task configurations.
* Simple installation, no additional configuration required.
## Dependencies
* [Arclight Forge](https://github.com/IzzelAliz/Arclight/releases/tag/1.16%2F1.0.25) for Minecraft 1.16.5
* [Pixelmon for 1.16.5](https://reforged.gg/)
* [LMBishop's Quests](https://github.com/LMBishop/Quests/releases) (minimum v3.15.2)
## Installation
* Place the `pixeltasktypes-{version}.jar` file in your Arclight server's `plugins` folder.
* Start/Restart the server.
* All done!
## Configuration
PixelTaskTypes has no configuration of its own, it instead extends LMBishop's Quests with additional task types to allow Pixelmon related quests to be created. Please refer to [their documentation](https://quests.leonardobishop.com/configuration/) for a full configuration setup.

The section below will showcase and explain the added task types. As this is just an extension, all existing quest configuration can be combined with the Pixelmon tasks to create even more diverse and unique quests.
### All Pixelmon Task Types
These fields are available for all Pixelmon-related tasks.

**Note**: Certain combinations can make a task impossible to complete. For example, setting `species` to `Pikachu` and `legendary_only` to `true` creates an invalid task, as Pikachu is not a legendary Pokémon and thus the progression criteria can never be met.
#### Required
* `amount` - Number of times the task must be completed.
#### Optional
* `species` - List of Pokémon species that count toward progress.
* `not_species` - List of Pokémon species that will not count toward progress.
* `pokemon_types` - List of Pokémon types that count toward progress.
* `palettes` - List of Pokémon palettes that count toward progress. (See the [Pixelmon Wiki](https://pixelmonmod.com/wiki/Form_indices) for available palettes.)
* `legendary_only` - If `true`, only legendary Pokémon count toward progress.
* `pokemon_level` - Minimum level required for Pokémon to count.

### Catch Pokémon
Progress is made by catching Pokémon with Pokéballs.
#### Optional
* `poke_balls` - A list of Pokéballs that need to be used to progress the task.
#### Simple Example
Catch 20 Pokémon, no additional requirements.
```yml
type: "catch_pokemon"
amount: 20
```
#### Advanced Example
Catch a legendary Pokémon using a park ball or a master ball, not counting Articuno, Zapdos, or Moltres.
```yml
type: "catch_pokemon"
amount: 1
legendary_only: true
poke_balls:
    - "master_ball"
    - "park_ball"
not_species:
    - "articuno"
    - "zapdos"
    - "moltres"
```
### Defeat Pokémon
Progress is made by defeating Pokémon in battles.
#### Optional
* `wild_only` - If `true`, only wild Pokémon count.
* `pvp_only` - If `true`, only Pokémon defeated in PvP battles count.
#### Simple Example
Defeat 20 Pokémon, either in the wild or in PvP.
```yml
type: "defeat_pokemon"
amount: 20
```
#### Advanced Example
Defeat 10 Fire or Ice type Pokémon in the wild that are level 30 or higher.
```yml
type: "defeat_pokemon"
amount: 10
wild_only: true
pokemon_types:
    - "fire"
    - "ice"
level: 30
```

### Evolve Pokémon
Progress is made by evolving Pokémon.
#### Optional
* `evolution_types` - Specify required evolution methods. Options:
    * `leveling` - Evolve through leveling up.
    * `interact` - Evolve via items (e.g., Leaf Stone).
    * `ticking` - *Honestly no idea, haven't found a pokémon that uses this yet*
    * `trade` - Evolve through trading.
#### Simple Example
Evolve 5 Pokémon.
```yml
type: "evolve_pokemon"
amount: 5
```
#### Advanced Example
Evolve 3 Pokémon through leveling or trading.
```yml
type: "evolve_pokemon"
amount: 3
evolution_types:
    - "leveling"
    - "trading"
```
### Hatch Eggs
Progress is made by hatching Pokémon eggs.
#### Simple Example
Hatch 10 eggs.
```yml
type: "hatch_egg"
amount: 10
```
#### Advanced Example
Hatch a shiny Zorua or Eevee from an egg.
```yml
type: "hatch_egg"
amount: 1
palettes:
    - "shiny"
species:
    - "eevee"
    - "zorua"
```

### Fishing Pokémon
Progress is made by reeling in Pokémon when fishing.
#### Simple Example
Catch 10 Pokémon when fishing
```yml
type: "fish_pokemon"
amount: 10
```
#### Advanced Example
Catch 5 Magikarp using an old rod or a good rod
```yml
type: "fish_pokemon"
amount: 5
species:
    - "magikarp"
rods:
    - "old_rod"
    - "good_rod"
```

### Cleaning Fossils
Progress is made by cleaning fossils using a fossil cleaning machine.

Note that because cleaning a fossil does not produce an actual Pokémon, the Pokémon requirements such as species, level, palette etc. will not work for this task type.

#### Optional
* `fossil_types` - Specify a list of fossil types that will count towards progress. (See [Fossils](https://pixelmonmod.com/wiki/Fossils) for a list of available types. The type should be specified with "Fossil" excluded)
#### Simple Example
Clean 10 fossils
```yml
type: "clean_fossils"
amount: 10
```
#### Advanced Example
Clean 5 Amber or Helix fossils
```yml
type: "clean_fossils"
amount: 5
fossil_types:
    - "amber"
    - "helix"
```

### Using Moves
Progress is made by using moves in battle.
#### Optional
* `moves` - Specify a list of moves that will count towards progress.
#### Simple Example
Use 10 moves in battle
```yml
type: "use_moves"
amount: 10
```
#### Advanced Example
Use sucker punch 15 times
```yml
type: "use_moves"
amount: 15
moves:
    - "sucker_punch"
```
