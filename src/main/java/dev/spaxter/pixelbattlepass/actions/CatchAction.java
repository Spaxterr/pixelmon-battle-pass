package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class CatchAction extends PixelmonActionContainer {
    public CatchAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a Pokémon is successfully captured.
     */
    @SubscribeEvent()
    public void onPokemonCatch(final CaptureEvent.SuccessfulCapture event) {
        Pokemon pokemon = event.getPokemon().getPokemon();
        this.progressWithPokemon("catch", pokemon, event.getPlayer());
    }
}
