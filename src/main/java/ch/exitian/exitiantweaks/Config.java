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
            .comment("Speed of the vanilla minecart.")
            .comment("\"1.2\" is vanilla default maximum speed. High speeds will probably derail the cart.")
            .comment("Default: 1.2")
            .defineInRange("minecartMaxSpeed", 1.2d, 0.5d, 20d);

    private static final ModConfigSpec.IntValue LEFT_BAR_HEIGHT = BUILDER
            .comment("Height of the heart and armor bar offset.")
            .comment("Default: 0")
            .defineInRange("leftBarHeightOffset", 0, -50, 50);

    private static final ModConfigSpec.IntValue RIGHT_BAR_HEIGHT = BUILDER
            .comment("Height of the food bar offset.")
            .comment("Default: 0")
            .defineInRange("rightBarHeightOffset", 0, -50, 50);

    private static final ModConfigSpec.BooleanValue ALLOW_NETHER_PORTAL = BUILDER
            .comment("Whether to allow the nether portal from building")
            .comment("\"False\" disables forming.")
            .comment("Default: true")
            .define("allowNetherPortalForming", true);

    private static final ModConfigSpec.BooleanValue GENERATE_LARGE_ORE_NODES = BUILDER
            .comment("Whether to generate large ore nodes.")
            .comment("\"False\" disables the carver-ores.")
            .comment("Default: true")
            .define("generateLargeOreNodes", true);

    private static final ModConfigSpec.BooleanValue DISABLE_NARRATOR = BUILDER
            .comment("Whether to mute and disable the narrator onboarding on first startup.")
            .comment("\"True\" disables the Narrator.")
            .comment("default: true")
            .define("disableAccessibilityOnboardingScreen", true);

    public static Boolean allowNetherPortalForming;
    public static Double minecartSpeed;
    public static Integer leftBarHeightOffset;
    public static Integer rightBarHeightOffset;
    public static Boolean generateLargeOreNodes;
    public static Boolean disableAccessibilityOnboardingScreen;

    static final ModConfigSpec SPEC = BUILDER.build();
    private static boolean validateModName(final Object obj)
    {
        return obj instanceof String modName && net.neoforged.fml.ModList.get().getMods().toString().contains(modName);
    }

    @SubscribeEvent
    static void onLoad(
            final ModConfigEvent event)
    {
        allowNetherPortalForming = ALLOW_NETHER_PORTAL.get();
        minecartSpeed = MINECART_SPEED.get();
        leftBarHeightOffset = LEFT_BAR_HEIGHT.get();
        rightBarHeightOffset = RIGHT_BAR_HEIGHT.get();
        generateLargeOreNodes = GENERATE_LARGE_ORE_NODES.get();
        disableAccessibilityOnboardingScreen = DISABLE_NARRATOR.get();
    }
}
