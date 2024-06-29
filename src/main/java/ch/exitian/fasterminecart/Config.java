package ch.exitian.fasterminecart;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import static ch.exitian.fasterminecart.FasterMinecart.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue MINECART_SPEED = BUILDER
            .comment("Speed of the minecart.")
            .defineInRange("magicNumber", 3d, 1d, 20d);

    public static Double minecartSpeed;

    static final ModConfigSpec SPEC = BUILDER.build();
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        minecartSpeed = MINECART_SPEED.get();
    }
}
