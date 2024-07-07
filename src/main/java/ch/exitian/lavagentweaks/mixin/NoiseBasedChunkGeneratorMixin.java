package ch.exitian.lavagentweaks.mixin;

import ch.exitian.lavagentweaks.config.Config;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Inject(method = "createFluidPicker", at = @At("HEAD"), cancellable = true)
    private static void createFluidPicker(NoiseGeneratorSettings pSettings, CallbackInfoReturnable<Aquifer.FluidPicker> cir) {
        Aquifer.FluidStatus aquifer$fluidstatus = new Aquifer.FluidStatus(Config.lavaLevelMin, Blocks.LAVA.defaultBlockState());
        int i = pSettings.seaLevel();
        Aquifer.FluidStatus aquifer$fluidstatus1 = new Aquifer.FluidStatus(i, pSettings.defaultFluid());
        cir.setReturnValue((p_224274_, p_224275_, p_224276_) -> p_224275_ < Math.min(Config.lavaLevelMin, i) ? aquifer$fluidstatus : aquifer$fluidstatus1);
    }
}