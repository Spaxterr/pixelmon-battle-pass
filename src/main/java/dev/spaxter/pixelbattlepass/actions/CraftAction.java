package dev.spaxter.pixelbattlepass.actions;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistryEntry;

import dev.spaxter.pixelbattlepass.util.ArclightUtils;

import io.izzel.arclight.api.Arclight;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Catch Pokémon task type.
 */
public class CraftAction extends PixelmonActionContainer {
    public CraftAction(JavaPlugin plugin) {
        super();
        Arclight.registerForgeEvent(plugin, MinecraftForge.EVENT_BUS, this);
    }

    /**
     * Runs when a fossil item is retrieved from the cleaner.
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onItemCraft(final ItemCraftedEvent event) {
        ItemStack crafted = event.getCrafting();
        ForgeRegistryEntry<?> registryEntry = crafted.getItem();
        Player bukkitPlayer = ArclightUtils.getBukkitPlayer(event.getPlayer().getUUID());
        if (registryEntry != null) {
            int count = crafted.getStack().getCount();
            String name = registryEntry.toString().toLowerCase();

            super.executionBuilder("craft")
                .player(bukkitPlayer)
                .canBeAsync()
                .root(name)
                .progress(count)
                .buildAndExecute();
        }
    }
}
