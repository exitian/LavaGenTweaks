package ch.exitian.exitiantweaks;

import ch.exitian.exitiantweaks.config.Config;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import squeek.appleskin.api.event.HUDOverlayEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = "appleskin")
public final class AppleSkinEventHandler {

    @SubscribeEvent
    public static void offsetAppleskin(HUDOverlayEvent event) {
        event.y = event.guiGraphics.guiHeight() - Config.offsetAppleskin;
    }
}
