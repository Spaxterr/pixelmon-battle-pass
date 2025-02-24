package dev.spaxter.pixelbattlepass.actions;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;
import net.minecraft.entity.player.PlayerEntity;

import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.api.pokemon.PokemonSpecificationProxy;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.PixelBattlePass;
import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import io.izzel.arclight.api.Arclight;

import java.util.function.Predicate;

import org.bukkit.entity.Player;

/**
 * Custom action container for Pixelmon quest types.
 */
public abstract class PixelmonActionContainer extends ExternalActionContainer {
    public PixelmonActionContainer() {
        super(PixelBattlePass.PLUGIN, "pixelmon");
        Arclight.registerForgeEvent(PixelBattlePass.PLUGIN, Pixelmon.EVENT_BUS, this);
    }

    /**
     * Check the target Pokémon given the quest name and player and progress any matching quests.
     */
    public void progressWithPokemon(String questName, final Pokemon pokemon, final PlayerEntity player) {
        Player bukkitPlayer = ArclightUtils.getBukkitPlayer(player.getUUID());

        super.executionBuilder(questName)
            .canBeAsync()
            .player(bukkitPlayer)
            .subRoot("specs", this.checkPokemonSpecs(pokemon))
            .subRoot("min_level", this.checkPokemonLevel(pokemon))
            .progressSingle()
            .buildAndExecute();
    }

    private Predicate<Object> checkPokemonSpecs(Pokemon pokemon) {
        return (spec) -> {
            PokemonSpecification specification = PokemonSpecificationProxy.create(spec);
            return specification.matches(pokemon);
        };
    }

    private Predicate<Object> checkPokemonLevel(Pokemon pokemon) {
        return (minLevel) -> {
            int level = pokemon.getPokemonLevel();
            return level >= Integer.valueOf(minLevel.toString());
        };
    }
}
