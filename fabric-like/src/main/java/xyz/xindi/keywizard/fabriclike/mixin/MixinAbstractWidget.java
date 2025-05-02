package xyz.xindi.keywizard.fabriclike.mixin;

import net.minecraft.client.gui.components.AbstractWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.xindi.keywizard.fabriclike.extension.AbstractWidgetExtension;

@Mixin(AbstractWidget.class)
public class MixinAbstractWidget implements AbstractWidgetExtension {

    @Shadow public boolean active;

    @Unique
    private int keywizard$fgColor = -1;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void keywizard$init(CallbackInfo ci) {
        keywizard$fgColor = -1;
    }

    // getter & setter method
    @Unique
    @Override
    public int keywizard$getFGColor() {
        return keywizard$fgColor != -1 ? keywizard$fgColor : (this.active ? 0xFFFFFF : 0xA0A0A0);
    }

    @Unique
    @Override
    public void keywizard$setFGColor(int color) {
        keywizard$fgColor = color;
    }
}