package dev.spaxter.pixelbattlepass;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import dev.spaxter.pixelbattlepass.actions.CatchAction;
import dev.spaxter.pixelbattlepass.actions.DefeatWildAction;
import dev.spaxter.pixelbattlepass.actions.EvolveAction;
import dev.spaxter.pixelbattlepass.actions.FishingAction;
import dev.spaxter.pixelbattlepass.actions.HatchingAction;
import dev.spaxter.pixelbattlepass.util.Resources;
import io.github.battlepass.BattlePlugin;
import net.advancedplugins.bp.impl.actions.ActionRegistry;

/**
 * Pixel Task Types main class.
 *
 * @author Spaxter
 */
public final class PixelBattlePass extends JavaPlugin {

    public static JavaPlugin PLUGIN;
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        PLUGIN = (JavaPlugin) this;
        LOGGER = this.getLogger();
        String art = Resources.readAsString(this.getResource("art.txt"));
        this.getLogger().info("\n" + art);
        this.registerActions();
    }

    private void registerActions() {
        LOGGER.info("Registering actions...");
        ActionRegistry actionRegistry = BattlePlugin.getPlugin().getActionRegistry();

        actionRegistry.quest(CatchAction::new);
        actionRegistry.quest(DefeatWildAction::new);
        actionRegistry.quest(EvolveAction::new);
        actionRegistry.quest(FishingAction::new);
        actionRegistry.quest(HatchingAction::new);

        LOGGER.info("Registered all actions successfully!");
    }

    private boolean checkArclight() {
        try {
            Class.forName("net.minecraftforge.common.MinecraftForge");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private boolean checkPixelmon() {
        try {
            Class.forName("com.pixelmonmod.pixelmon.Pixelmon");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
