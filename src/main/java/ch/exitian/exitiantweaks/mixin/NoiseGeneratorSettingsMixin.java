package ch.exitian.exitiantweaks.mixin;

import ch.exitian.exitiantweaks.Config;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin {

    @Inject(method = "oreVeinsEnabled", at = @At("HEAD"), cancellable = true)
    public void oreVeinsEnabled1(CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(Config.generateLargeOreNodes);
    }
}