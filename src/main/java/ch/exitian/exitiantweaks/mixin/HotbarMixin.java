package ch.exitian.exitiantweaks.mixin;

import ch.exitian.exitiantweaks.config.Config;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.Gui;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static ch.exitian.exitiantweaks.config.Config.leftBarHeightOffset;

@Mixin(Gui.class)
public abstract class HotbarMixin {

    @ModifyExpressionValue(method = "renderFoodLevel", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/Gui;rightHeight:I", opcode = Opcodes.GETFIELD))
    private int rHeightLower(int original) {
        return ((Config.disableXP) ? original - (leftBarHeightOffset+6) : original - leftBarHeightOffset);
    }

    @ModifyExpressionValue(method = "renderHealthLevel", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/Gui;leftHeight:I", opcode = Opcodes.GETFIELD))
    private int lHeightLower(int original) {
        return ((Config.disableXP) ? original - (leftBarHeightOffset+6) : original - leftBarHeightOffset);
    }

    @Inject(method = "isExperienceBarVisible", at = @At("HEAD"), cancellable = true)
    private void disableXPBar(CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(!Config.disableXP);
    }

}

