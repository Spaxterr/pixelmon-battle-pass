package dev.spaxter.pixelbattlepass;

import org.bukkit.plugin.java.JavaPlugin;

import dev.spaxter.pixelbattlepass.util.Resources;

/**
 * Pixel Task Types main class.
 *
 * @author Spaxter
 */
public final class PixelBattlePass extends JavaPlugin {
    @Override
    public void onEnable() {
        String art = Resources.readAsString(this.getResource("art.txt"));
        this.getLogger().info(art);
    }

    private void registerEvents() {
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
