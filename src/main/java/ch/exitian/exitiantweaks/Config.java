package ch.exitian.exitiantweaks;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import static ch.exitian.exitiantweaks.ExitianTweaks.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue MINECART_SPEED = BUILDER
            .comment("Speed of the minecart.")
            .defineInRange("minecartMaxSpeed", 3d, 1d, 20d);

    private static final ModConfigSpec.IntValue LEFT_BAR_HEIGHT = BUILDER
            .comment("Height of the heart and armor bar offset")
            .defineInRange("leftBarHeightOffset", 6, -50, 50);

    private static final ModConfigSpec.IntValue RIGHT_BAR_HEIGHT = BUILDER
            .comment("Height of the food bar offset")
            .defineInRange("rightBarHeightOffset", 6, -50, 50);

    public static Double minecartSpeed;
    public static Integer rightBarHeightOffset;
    public static Integer leftBarHeightOffset;

    static final ModConfigSpec SPEC = BUILDER.build();
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(
            final ModConfigEvent event)
    {
        minecartSpeed = MINECART_SPEED.get();
        leftBarHeightOffset = LEFT_BAR_HEIGHT.get();
        rightBarHeightOffset = RIGHT_BAR_HEIGHT.get();
    }
}
