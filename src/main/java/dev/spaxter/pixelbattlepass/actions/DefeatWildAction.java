package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
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
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPokemonDefeat(final BeatWildPixelmonEvent event) {
        Pokemon pokemon = event.wpp.getFaintedPokemon().pokemon;
        Player player = ArclightUtils.getBukkitPlayer(event.player.getUUID());

        super.executionBuilder("defeat_wild")
            .canBeAsync()
            .player(player)
            .subRoot("specs", this.specs(pokemon))
            .progressSingle()
            .buildAndExecute();
    }
}
