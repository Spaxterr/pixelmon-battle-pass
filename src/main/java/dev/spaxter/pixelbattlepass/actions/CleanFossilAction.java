package dev.spaxter.pixelbattlepass.actions;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.FossilCleanerEvent;
import com.pixelmonmod.pixelmon.items.FossilItem;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class CleanFossilAction extends PixelmonActionContainer {
    public CleanFossilAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a fossil item is retrieved from the cleaner.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onFossilClean(final FossilCleanerEvent.ObtainingCleanFossil event) {
        if (event.getFossil() instanceof FossilItem fossil) {
            Player player = ArclightUtils.getBukkitPlayer(event.getPlayer().getUUID());
            String fossilType = fossil.getFossil().name().toLowerCase();

            super.executionBuilder("clean_fossil")
                .canBeAsync()
                .player(player)
                .root(fossilType)
                .progressSingle()
                .buildAndExecute();
        }
    }
}
