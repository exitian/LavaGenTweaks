package ch.exitian.lavagentweaks.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import static ch.exitian.lavagentweaks.LavaGenTweaks.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue LAVA_LEVEL_MIN = BUILDER
            .comment("Set the lava sea level. You can set this above the waterlevel")
            .comment("Default: -54 (Vanilla default)")
            .comment("DO NOT CHANGE THIS AFTER WORLD GENERATION. It will probably break stuff.")
            .defineInRange("lavaLevelMin", -54, -4096, 4096);

    public static Integer lavaLevelMin;
    public static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(
            final ModConfigEvent event) {
        lavaLevelMin = LAVA_LEVEL_MIN.get();
    }
}
