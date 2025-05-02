package xyz.xindi.keywizard.platform.forge;

import net.minecraft.client.gui.components.AbstractWidget;

public class WidgetHelperImpl {
    public static int getFGColor(AbstractWidget widget, boolean active) {
        return widget.getFGColor();
    }

    public static void setFGColor(AbstractWidget widget, int color) {
        widget.setFGColor(color);
    }

    public static void clearFGColor(AbstractWidget widget) {
        widget.clearFGColor();
    }
}