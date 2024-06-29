package com.example.examplemod.mixins;

import net.neoforged.neoforge.common.extensions.IAbstractMinecartExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IAbstractMinecartExtension.class)
public class MinecartMixin {
    @Inject (method = "getMaxCartSpeedOnRail", at = @At("HEAD"), cancellable = true)
    public void getMaxCartSpeedOnRail(CallbackInfoReturnable<Float> callback) {
        callback.setReturnValue(50.0f);
    }
}
