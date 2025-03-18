package dev.spaxter.pixelbattlepass.actions;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.battles.AttackEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class MoveAction extends PixelmonActionContainer {
    public MoveAction(JavaPlugin plugin) {
        super();
    }

    /**
     * Runs when a move is used in battle.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onMoveUse(final AttackEvent.Use event) {
        ServerPlayerEntity player = event.user.getPlayerOwner();

        if (player == null) {
            return;
        }

        Player bukkitPlayer = ArclightUtils.getBukkitPlayer(player.getUUID());
        final String attackName = event.attack.getAttackName().toLowerCase();
        final Pokemon pokemon = event.target.pokemon;

        super.executionBuilder("use_move")
            .canBeAsync()
            .player(bukkitPlayer)
            .root(attackName)
            .subRoot("specs", super.specs(pokemon))
            .progressSingle()
            .buildAndExecute();
    }
}
