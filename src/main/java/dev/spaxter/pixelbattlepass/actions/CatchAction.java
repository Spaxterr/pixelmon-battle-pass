package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
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
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPokemonCatch(final CaptureEvent.SuccessfulCapture event) {
        Player player = ArclightUtils.getBukkitPlayer(event.getPlayer().getUUID());
        Pokemon pokemon = event.getPokemon().getPokemon();

        super.executionBuilder("catch")
            .canBeAsync()
            .player(player)
            .subRoot("specs", this.specs(pokemon))
            .progressSingle()
            .buildAndExecute();
    }
}
