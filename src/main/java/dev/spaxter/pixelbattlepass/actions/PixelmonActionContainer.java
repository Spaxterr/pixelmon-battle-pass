package dev.spaxter.pixelbattlepass.actions;

import net.advancedplugins.bp.impl.actions.containers.ExternalActionContainer;

import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.api.pokemon.PokemonSpecificationProxy;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.PixelBattlePass;

import io.izzel.arclight.api.Arclight;

import java.util.function.Predicate;

/**
 * Custom action container for Pixelmon quest types.
 */
public abstract class PixelmonActionContainer extends ExternalActionContainer {
    public PixelmonActionContainer() {
        super(PixelBattlePass.PLUGIN, "pixelmon");
        Arclight.registerForgeEvent(PixelBattlePass.PLUGIN, Pixelmon.EVENT_BUS, this);
    }

    /**
     * Root checker for Pokémon specs.
     *
     * @param pokemon The Pokémon to check.
     * @return `true` if the given Pokémon matches the spec(s) configured for the quest.
     */
    public Predicate<Object> specs(Pokemon pokemon) {
        return (spec) -> {
            final PokemonSpecification specification = PokemonSpecificationProxy.create(spec);
            return specification.matches(pokemon);
        };
    }
}
