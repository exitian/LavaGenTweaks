package ch.exitian.exitiantweaks;

import ch.exitian.exitiantweaks.config.Config;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ExitianTweaks.MODID)
public class ExitianTweaks {
    public static final String MODID = "exitiantweaks";

    public static final TagKey<Item> deathPreventables = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "death_preventables"));
    public static final TagKey<Item> willBurnPlayers = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "will_burn_players"));
    public static final TagKey<Item> heatResistantItems = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "heat_resistant_items"));

    public ExitianTweaks(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(EventHandler.class);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        if (ModList.get().isLoaded("appleskin")) {
            NeoForge.EVENT_BUS.register(new AppleSkinEventHandler());
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

//    // Add the example block item to the building blocks tab
//    private void addCreative(BuildCreativeModeTabContentsEvent event)
//    {
//    }
//
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//        Exitian
//    }
//
//        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents
//    {
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event)
//        {
//
//        }
//    }
}
