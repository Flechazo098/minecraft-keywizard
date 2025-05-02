package xyz.xindi.keywizard.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.gui.components.AbstractWidget;

public class WidgetHelp {

    /**
     * 获取Widget的前景色
     *
     */
    @ExpectPlatform
    public static int getFGColor(AbstractWidget widget, boolean active) {

        throw new AssertionError("平台实现未加载");
    }

    /**
     * 设置Widget的前景色
     */
    @ExpectPlatform
    public static void setFGColor(AbstractWidget widget, int color) {

        throw new AssertionError("平台实现未加载");
    }
}