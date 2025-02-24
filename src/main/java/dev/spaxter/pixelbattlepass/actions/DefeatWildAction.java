package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class DefeatWildAction extends PixelmonActionContainer {
    public DefeatWildAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a Pokémon is successfully captured.
     */
    @SubscribeEvent()
    public void onPokemonDefeat(final BeatWildPixelmonEvent event) {
        Pokemon pokemon = event.wpp.getFaintedPokemon().pokemon;
        this.progressWithPokemon("defeat_wild", pokemon, event.player);
    }
}
