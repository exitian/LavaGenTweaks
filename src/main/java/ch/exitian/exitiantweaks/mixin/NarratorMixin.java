package ch.exitian.exitiantweaks.mixin;

import ch.exitian.exitiantweaks.Config;
import com.mojang.text2speech.Narrator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Narrator.class)
public interface NarratorMixin {

    @Inject(method = "active", at = @At(value = "HEAD"), cancellable = true)
    private void narratorActive(CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(Config.disableAccessibilityOnboardingScreen);
    }

}