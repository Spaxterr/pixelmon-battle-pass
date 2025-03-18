package dev.spaxter.pixelbattlepass.actions;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.PixelmonKnockoutEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class DefeatPvpAction extends PixelmonActionContainer {
    public DefeatPvpAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a wild Pokémon is defeated.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPvpDefeat(final PixelmonKnockoutEvent event) {
        final ServerPlayerEntity player = event.source.getPlayerOwner();
        final ServerPlayerEntity opponent = event.pokemon.getPlayerOwner();

        if (player == null || opponent == null) {
            return;
        }

        Player bukkitPlayer = ArclightUtils.getBukkitPlayer(player.getUUID());
        Pokemon pokemon = event.pokemon.pokemon;

        super.executionBuilder("defeat_pvp")
            .canBeAsync()
            .player(bukkitPlayer)
            .subRoot("specs", this.specs(pokemon))
            .progressSingle()
            .buildAndExecute();
    }
}
