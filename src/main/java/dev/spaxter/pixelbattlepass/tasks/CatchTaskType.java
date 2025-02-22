package dev.spaxter.pixelbattlepass.tasks;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;

/**
 * Catch Pokémon task type.
 */
public class CatchTaskType {
    public CatchTaskType() {
    }

    /**
     * Runs when a Pokémon is successfully captured.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPokemonCatch(final CaptureEvent.SuccessfulCapture event) {
    }
}
