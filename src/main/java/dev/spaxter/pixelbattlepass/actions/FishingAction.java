package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.FishingEvent;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class FishingAction extends PixelmonActionContainer {
    public FishingAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a Pokémon is reeled in with a fishing rod.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onFishingReel(final FishingEvent.Reel event) {
        if (event.optEntity.isEmpty() || !event.isPokemon()) {
            return;
        }

        if (event.optEntity.get() instanceof PixelmonEntity pokemonEntity) {
            String rod = event.getRodType().toString().toLowerCase();
            Player player = ArclightUtils.getBukkitPlayer(event.player.getUUID());
            super.executionBuilder("fish")
                .canBeAsync()
                .player(player)
                .subRoot("specs", this.specs(pokemonEntity.getPokemon()))
                .subRoot("rod", rod)
                .progressSingle()
                .buildAndExecute();
        }
    }
}
