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
            .comment("Default: 2")
            .defineInRange("minecartMaxSpeed", 3d, 1d, 20d);

    private static final ModConfigSpec.IntValue LEFT_BAR_HEIGHT = BUILDER
            .comment("Height of the heart and armor bar offset.")
            .comment("Default: 6")
            .defineInRange("leftBarHeightOffset", 6, -50, 50);

    private static final ModConfigSpec.IntValue RIGHT_BAR_HEIGHT = BUILDER
            .comment("Height of the food bar offset.")
            .comment("Default: 6")
            .defineInRange("rightBarHeightOffset", 6, -50, 50);

    private static final ModConfigSpec.BooleanValue ALLOW_NETHER_PORTAL = BUILDER
            .comment("Whether to allow the nether portal from building")
            .comment("Default: false")
            .define("allowNetherPortalForming", false);

    public static Boolean allowNetherPortalForming;
    public static Double minecartSpeed;
    public static Integer leftBarHeightOffset;
    public static Integer rightBarHeightOffset;

    static final ModConfigSpec SPEC = BUILDER.build();
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(
            final ModConfigEvent event)
    {
        allowNetherPortalForming = ALLOW_NETHER_PORTAL.get();
        minecartSpeed = MINECART_SPEED.get();
        leftBarHeightOffset = LEFT_BAR_HEIGHT.get();
        rightBarHeightOffset = RIGHT_BAR_HEIGHT.get();
    }
}
