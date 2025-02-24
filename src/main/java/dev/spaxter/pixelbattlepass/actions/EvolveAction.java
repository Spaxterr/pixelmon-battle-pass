package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.EvolveEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class EvolveAction extends PixelmonActionContainer {
    public EvolveAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a Pokémon is successfully captured.
     */
    @SubscribeEvent()
    public void onPokemonEvolve(final EvolveEvent.Post event) {
        Pokemon pokemon = event.getPokemon();
        this.progressWithPokemon("evolve", pokemon, event.getPlayer());
    }
}
