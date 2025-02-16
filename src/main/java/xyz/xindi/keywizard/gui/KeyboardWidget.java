package xyz.xindi.keywizard.gui;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.client.Minecraft;
import xyz.xindi.keywizard.mixin.KeyBindingAccessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class KeyboardWidget
        extends AbstractContainerEventHandler implements Renderable, TickableElement, NarratableEntry
{
    public KeyWizardScreen keyWizardScreen;

    private HashMap<Integer, KeyboardKeyWidget> keys = new HashMap<>();

    private float anchorX;

    private float anchorY;

    protected KeyboardWidget(KeyWizardScreen keyWizardScreen, float anchorX, float anchorY) {
        this.keyWizardScreen = keyWizardScreen;
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }

    public float addKey(float relativeX, float relativeY, float width, float height, float keySpacing, int keyCode) {
        this.keys.put(Integer.valueOf(keyCode), new KeyboardKeyWidget(keyCode, this.anchorX + relativeX, this.anchorY + relativeY, width, height, InputConstants.Type.KEYSYM));
        return relativeX + width + keySpacing;
    }

    public float addKey(float relativeX, float relativeY, float width, float height, float keySpacing, int keyCode, InputConstants.Type keyType) {
        this.keys.put(Integer.valueOf(keyCode), new KeyboardKeyWidget(keyCode, this.anchorX + relativeX, this.anchorY + relativeY, width, height, keyType));
        return relativeX + width + keySpacing;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
                List<? extends KeyboardKeyWidget> keys = children();
        for (KeyboardKeyWidget k : keys)
            k.render(graphics, mouseX, mouseY, partialTick);
//        if (!this.keyWizardScreen.getCategorySelectorExtended())
//            for (KeyboardKeyWidget k : keys) {
//                if (k.f_93623_ && k.m_198029_())
//                    this.keyWizardScreen.m_96597_(matrices, k.tooltipText, mouseX, mouseY);
//            }
    }

//    public boolean m_6375_(double mouseX, double mouseY, int button) {
//        if (!this.keyWizardScreen.getCategorySelectorExtended())
//            for (KeyboardKeyWidget k : m_6702_()) {
//                if (k.m_6375_(mouseX, mouseY, button))
//                    return true;
//            }
//        return false;
//    }

    @Override
    public List<? extends KeyboardKeyWidget> children() {
        return new ArrayList<>(this.keys.values());
    }

    public void tick() {
        for (KeyboardKeyWidget k : children())
            k.tick();
    }

    @Override
    public NarrationPriority narrationPriority() {
        return NarrationPriority.NONE;
    }

    @Override
    public void updateNarration(NarrationElementOutput p_169152_) {

    }

    //
//    public float getAnchorX() {
//        return this.anchorX;
//    }
//
//    public float getAnchorY() {
//        return this.anchorY;
//    }
//
    public class KeyboardKeyWidget extends AbstractButton implements TickableElement {
        private InputConstants.Key key;

        private List<Component> tooltipText = new ArrayList<>();

        protected KeyboardKeyWidget(int keyCode, float x, float y, float width, float height, InputConstants.Type keyType) {
            super((int)x, (int)y, (int)width, (int)height, Component.empty());
            this.setX((int)x);
            this.setY((int)y);
            this.width = (int)width;
            this.height = (int)height;
            this.key = keyType.getOrCreate(keyCode);
            this.setMessage(MutableComponent.create(this.key.getDisplayName().getContents()));
        }

        @Override
        public int getFGColor() {
            int bindingCount = this.tooltipText.size();
            int color = 0;
            if (this.visible) {
                if (!KeyboardWidget.this.keyWizardScreen.getCategorySelectorExtended()) {
                    color = -5592406;
                    if (bindingCount == 1) {
                        color = -16733696;
                    } else if (bindingCount > 1) {
                        color = -5636096;
                    }
                } else {
                    color = -1;
                    if (bindingCount == 1) {
                        color = -16711936;
                    } else if (bindingCount > 1) {
                        color = -65536;
                    }
                }
            } else {
                color = -11184811;
            }

            return color;
        }

        //        @Override
//        public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
//            int bindingCount = this.tooltipText.size();
//            int color = 0;
//            if (this.visible) {
//                if (m_198029_() && !KeyboardWidget.this.keyWizardScreen.getCategorySelectorExtended()) {
//                    color = -5592406;
//                    if (bindingCount == 1) {
//                        color = -16733696;
//                    } else if (bindingCount > 1) {
//                        color = -5636096;
//                    }
//                } else {
//                    color = -1;
//                    if (bindingCount == 1) {
//                        color = -16711936;
//                    } else if (bindingCount > 1) {
//                        color = -65536;
//                    }
//                }
//            } else {
//                color = -11184811;
//            }
//            DrawingUtil.drawNoFillRect(matrices, this.x, this.y, this.x + this.width, this.y + this.height, color);
//            Font textRenderer = (Minecraft.getInstance()).font;
//            textRenderer.m_92763_(matrices, m_6035_(), this.x + this.width / 2.0F - (textRenderer
//                    .m_92852_((FormattedText)m_6035_()) / 2), this.y + (this.height - 6.0F) / 2.0F, color);
//        }
//
//        public void m_5691_() {
//            m_7435_(Minecraft.m_91087_().m_91106_());
//            if (Screen.m_96638_()) {
//                String keyName;
//                Component t = m_6035_();
//                if (t instanceof TranslatableContents) {
//                    keyName = I18n.m_118938_(((TranslatableContents)t).m_237508_(), new Object[0]);
//                } else {
//                    keyName = t.getString();
//                }
//                KeyboardWidget.this.keyWizardScreen.setSearchText("<" + keyName + ">");
//            } else {
//                KeyMapping selectedKeyBinding = KeyboardWidget.this.keyWizardScreen.getSelectedKeyBinding();
//                if (selectedKeyBinding != null) {
//                    selectedKeyBinding.m_90848_(this.key);
//                    KeyMapping.m_90854_();
//                }
//            }
//        }

        private void updateTooltip() {
            ArrayList<String> tooltipText = new ArrayList<>();
            for (KeyMapping b : (Minecraft.getInstance()).options.keyMappings) {
                if (b.getKey().equals(this.key))
                    this.tooltipText.add(MutableComponent.create(b.getTranslatedKeyMessage().getContents()));
            }
        }

        public void tick() {
            updateTooltip();
        }

        @Override
        public void onPress() {

        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput p_259858_) {

        }
    }
}
