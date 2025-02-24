# Pixelmon Battle Pass
## Overview
This plugin bridges the gap between the popular Pixelmon mod and AdvancedPlugins Battle Pass, allowing server administrators to create quests and challenges based on Pixelmon activities. Players can now earn Battle Pass progress and rewards by completing Pixelmon-related tasks such as catching Pokémon, winning battles, evolving Pokémon, hatching eggs, and more.

## Features
* **Pixelmon Quests**: Create battle pass quests for:
    * Catching Pokémon
    * Defeating Pokémon
    * Evolving Pokémon
    * Hatching eggs
    * Fishing

## Requirements
* Spigot for 1.16.5
* Pixelmon 9.1.12 or later
* Arclight for 1.16.5
* AdvancedPlugins 9.2.6 or later

## Installation
- Ensure you have Pixelmon and Battle Pass properly installed on your server
- Download the latest release JAR file from the releases page
- Place the JAR file in your server's `plugins` folder
- Restart your server


## Configuration
All Pokémon related quests can be configured to check for specific Pixelmon specifications on the target Pokémon. This is done by setting `variable.root` to `none` and providing a list of acceptable specs to the `variable.specs` field.

The specs are evaluated using **OR** logic. This means that every item provided in `variable.specs` will be matched against the target Pokémon, and if any one of them are true, the quest will progress.

For example:
```yaml
variable:
    root: none
    specs:
        - "species:rattata"
        - "type:fire shiny:true nature:bold"
```

This will create a quest that is progressed if the target Pokémon is either a Rattata, or a shiny fire type Pokémon with the **bold** nature.

## Available specification patterns
All available specs are listed [here](https://pixelmonmod.com/wiki/Pokemon_spec), however these are the ones that may be commonly used for quests:
- `species:<species>` - The Pokémon species name (e.g., pikachu, charizard)
- `type:<type>` - The Pokémon type (e.g., fire, water, electric)
- `minlevel:<min level>` - The Pokémon's minimum level
- `maxlevel:<max level>` - The Pokémon's maximum level
- `shiny:<true/false>` - Whether the Pokémon is shiny
- `legendary:<true/false>` - Whether the Pokémon is a legendary Pokémon
- `gender:<gender>` - The Pokémon's gender (male/female/none)
- `nature:<nature>` - The Pokémon's nature (e.g., bold, timid, jolly)
- `ability:<ability>` - The Pokémon's ability (e.g., static, blaze)
- `form:<form>` - For Pokémon with multiple forms (e.g., alolan, galarian)

These can be combined in the same specification, separated by spaces.
### Catching
Triggers when a player catches a wild Pokémon.

**Example quest: Catch shiny Pikachu**
Catch a shiny Pikachu.
```yaml
name: 'Shiny Mascot Collector'
type: pixelmon_catch
variable:
    root: none
    specs:
        - "species:pikachu shiny:true"
required-progress: 1
```

#### Defeating Wild
Triggers when a player defeats a Pokémon in the wild.

**Example quest: Defeat Dragon-type Pokémon**  
Defeat 20 dragon-type Pokémon that are level 30 or higher.
```yaml
name: 'Dragon Slayer'
type: pixelmon_defeat_wild
variable:
    root: none
    specs:
        - "type:dragon minlevel:30"
required-progress: 20
```

#### Evolving
Triggers when a player's Pokémon evolves into a new form.

**Example quest: Evolve Fire-type Pokémon**  
Evolve Eevee into three different evolutions of your choice.
```yaml
name: 'Eevee Evolution Master'
type: pixelmon_evolve
variable:
    root: none
    specs:
        - "species:vaporeon"
        - "species:jolteon"
        - "species:flareon"
        - "species:espeon"
        - "species:umbreon"
        - "species:leafeon"
        - "species:glaceon"
        - "species:sylveon"
required-progress: 3
```

#### Hatching
Triggers when a player hatches a Pokémon from an egg.

**Example quest: Hatch starters**
Hatch 4 random starter Pokémon eggs with at least one being from each generation (I-IV)
```yml
name: 'Starter Surprise'
type: pixelmon_hatch
variable:
    root: none
    specs:
        - "species:bulbasaur,charmander,squirtle"
        - "species:chikorita,cyndaquil,totodile"
        - "species:treecko,torchic,mudkip"
        - "species:turtwig,chimchar,piplup"
required-progress: 4
```

#### Fishing
Triggers when a player fishes up a Pokémon.

**Example Quest: Reel in 5 Magikarp**
Catch 5 Magikarp.
```yml
name: 'Karp for Dinner'
type: pixelmon_fish
variable:
    root: none
    specs:
        - "species:magikarp"
required-progress: 5
```
