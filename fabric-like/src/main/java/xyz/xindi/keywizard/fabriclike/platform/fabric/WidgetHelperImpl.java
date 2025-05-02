package xyz.xindi.keywizard.fabriclike.platform.fabric;


import net.minecraft.client.gui.components.AbstractWidget;
import xyz.xindi.keywizard.fabriclike.extension.AbstractWidgetExtension;

public class WidgetHelperImpl {
    public static int getFGColor(AbstractWidget button) {
        return ((AbstractWidgetExtension) button).keywizard$getFGColor();
    }

    public static void setFGColor(AbstractWidget button, int color) {
        ((AbstractWidgetExtension) button).keywizard$setFGColor(color);
    }

}