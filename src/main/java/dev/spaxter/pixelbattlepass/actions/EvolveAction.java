package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.EvolveEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
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
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPokemonEvolve(final EvolveEvent.Post event) {
        Pokemon pokemon = event.getPokemon();
        Player player = ArclightUtils.getBukkitPlayer(event.getPlayer().getUUID());

        super.executionBuilder("evolve")
            .canBeAsync()
            .player(player)
            .subRoot("specs", this.specs(pokemon))
            .progressSingle()
            .buildAndExecute();
    }
}
