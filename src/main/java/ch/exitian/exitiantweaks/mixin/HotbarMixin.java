package ch.exitian.exitiantweaks.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.Gui;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static ch.exitian.exitiantweaks.Config.leftBarHeightOffset;
import static ch.exitian.exitiantweaks.Config.rightBarHeightOffset;

@OnlyIn(Dist.CLIENT)
@Mixin(Gui.class)
public abstract class HotbarMixin {

    @ModifyExpressionValue(method = "renderFoodLevel", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/Gui;rightHeight:I", opcode = Opcodes.GETFIELD))
    private int rHeightLower(int original) {
        return (original - rightBarHeightOffset);
    }

    @ModifyExpressionValue(method = "renderHealthLevel", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/Gui;leftHeight:I", opcode = Opcodes.GETFIELD))
    private int lHeightLower(int original) {
        return (original - leftBarHeightOffset);
    }

}