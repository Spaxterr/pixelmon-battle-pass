package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;

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
     * Runs when a wild Pokémon is defeated.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPokemonDefeat(final BeatWildPixelmonEvent event) {
        Player player = ArclightUtils.getBukkitPlayer(event.player.getUUID());
        for (PixelmonWrapper pokemon : event.wpp.allPokemon) {
            super.executionBuilder("defeat_wild")
                .canBeAsync()
                .player(player)
                .subRoot("specs", this.specs(pokemon.pokemon))
                .progressSingle()
                .buildAndExecute();
        }
    }
}
