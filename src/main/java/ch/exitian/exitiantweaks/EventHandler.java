package ch.exitian.exitiantweaks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = ExitianTweaks.MODID, bus=EventBusSubscriber.Bus.GAME)
public class EventHandler {

    @SubscribeEvent
    public static void PortalSpawnEvent(BlockEvent.PortalSpawnEvent event) {
        event.setCanceled(!Config.allowNetherPortalForming);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void narratorScreen(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof AccessibilityOnboardingScreen){
            if (Config.disableAccessibilityOnboardingScreen) {
                Minecraft.getInstance().setScreen(new TitleScreen());
            }
        }
    }

}
