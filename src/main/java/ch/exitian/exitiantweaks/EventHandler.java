package ch.exitian.exitiantweaks;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = ExitianTweaks.MODID, bus=EventBusSubscriber.Bus.GAME)
public class EventHandler {

    @SubscribeEvent
    public static void PortalSpawnEvent(BlockEvent.PortalSpawnEvent event) {
        event.setCanceled(!Config.allowNetherPortalForming);
    }
}
