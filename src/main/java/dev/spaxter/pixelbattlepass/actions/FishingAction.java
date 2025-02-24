package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.FishingEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class FishingAction extends PixelmonActionContainer {
    public FishingAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a Pokémon is successfully captured.
     */
    @SubscribeEvent()
    public void onFishingReel(final FishingEvent.Reel event) {
        if (event.optEntity.isEmpty()) {
            return;
        }

        if (event.optEntity.get() instanceof PixelmonEntity pokemonEntity) {
            Pokemon pokemon = pokemonEntity.getPokemon();
            this.progressWithPokemon("evolve", pokemon, event.player);
        }
    }
}
