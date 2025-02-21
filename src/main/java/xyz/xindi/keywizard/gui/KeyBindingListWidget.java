package xyz.xindi.keywizard.gui;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import xyz.xindi.keywizard.util.KeyBindingUtil;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyBindingListWidget
        extends AbstractSelectionList<KeyBindingListWidget.BindingEntry> implements TickableElement
{
    public KeyWizardScreen keyWizardScreen;

    private String currentFilterText = "";

    private String currentCategory = "key.categories.keywizard.all";

    public KeyBindingListWidget(KeyWizardScreen keyWizardScreen, int top, int left, int width, int height, int itemHeight) {
        super(Minecraft.getInstance(), width, height, top, itemHeight);
        this.keyWizardScreen = keyWizardScreen;
        for (KeyMapping k : Minecraft.getInstance().options.keyMappings)
            addEntry(new BindingEntry(k));
        setSelectedIndex(0);
    }

    @Override
    public int getRowWidth() {
        return this.width - 15;
    }

    //    @Nullable
//    public KeyMapping getSelectedKeyBinding() {
//        if (m_93511_() == null)
//            return null;
//        return ((BindingEntry)m_93511_()).keyBinding;
//    }
//
    private void updateList() {
//        boolean filterUpdate = !this.currentFilterText.equals(this.keyWizardScreen.getFilterText());
//        boolean categoryUpdate = !this.currentCategory.equals(this.keyWizardScreen.getSelectedCategory());
//        if (categoryUpdate || filterUpdate) {
//            if (categoryUpdate)
//                this.currentCategory = this.keyWizardScreen.getSelectedCategory();
//            KeyMapping[] bindings = getBindingsByCategory(this.currentCategory);
//            if (filterUpdate) {
//                this.currentFilterText = this.keyWizardScreen.getFilterText();
//                if (!this.currentFilterText.equals(""))
//                    bindings = filterBindings(bindings, this.currentFilterText);
//            }
//            m_6702_().clear();
//            if (bindings.length > 0) {
//                for (KeyMapping k : bindings)
//                    m_7085_(new BindingEntry(k));
//                m_6987_(m_6702_().get(0));
//            } else {
//                m_6987_(null);
//            }
//            m_93410_(0.0D);
//        }
    }
//
//    private KeyMapping[] filterBindings(KeyMapping[] bindings, String filterText) {
//        KeyMapping[] bindingsFiltered = bindings;
//        String keyNameRegex = "<.*>";
//        Matcher keyNameMatcher = Pattern.compile(keyNameRegex).matcher(filterText);
//        if (keyNameMatcher.find()) {
//            String keyNameWithBrackets = keyNameMatcher.group();
//            String keyName = keyNameWithBrackets.replace("<", "").replace(">", "");
//            filterText = filterText.replace(keyNameWithBrackets, "");
//            bindingsFiltered = filterBindingsByKey(bindingsFiltered, keyName);
//        }
//        if (!filterText.equals(""))
//            bindingsFiltered = filterBindingsByName(bindingsFiltered, filterText);
//        return bindingsFiltered;
//    }
//
//    private KeyMapping[] filterBindingsByName(KeyMapping[] bindings, String bindingName) {
//        String[] words = bindingName.split("\\s+");
//        KeyMapping[] bindingsFiltered = (KeyMapping[])Arrays.<KeyMapping>stream(bindings).filter(binding -> {
//            boolean flag = true;
//            for (String w : words)
//                flag = (flag && I18n.m_118938_(binding.m_90860_(), new Object[0]).toLowerCase().contains(w.toLowerCase()));
//            return flag;
//        }).toArray(x$0 -> new KeyMapping[x$0]);
//        return bindingsFiltered;
//    }
//
//    private KeyMapping[] filterBindingsByKey(KeyMapping[] bindings, String keyName) {
//        return (KeyMapping[])Arrays.<KeyMapping>stream(bindings).filter(b -> {
//            Component t = b.m_90863_();
//            return (t instanceof TranslatableContents) ? I18n.m_118938_(((TranslatableContents)t).m_237508_(), new Object[0]).toLowerCase().equals(keyName.toLowerCase()) : t.getString().toLowerCase().equals(keyName.toLowerCase());
//        }).toArray(x$0 -> new KeyMapping[x$0]);
//    }
//
//    private KeyMapping[] getBindingsByCategory(String category) {
//        Map<InputConstants.Key, Integer> bindingCounts;
//        KeyMapping[] bindings = Arrays.<KeyMapping>copyOf(this.f_93386_.f_91066_.f_92059_, this.f_93386_.f_91066_.f_92059_.length);
//        switch (category) {
//            case "key.categories.keywizard.all":
//                return bindings;
//            case "key.categories.keywizard.conflicts":
//                bindingCounts = KeyBindingUtil.getBindingCountsByKey();
//                return (KeyMapping[])Arrays.<KeyMapping>stream(bindings).filter(b -> (((Integer)bindingCounts.get(((KeyBindingAccessor)b).getBoundKey())).intValue() > 1 && ((KeyBindingAccessor)b).getBoundKey().m_84873_() != -1)).toArray(x$0 -> new KeyMapping[x$0]);
//            case "key.categories.keywizard.unbound":
//                return (KeyMapping[])Arrays.<KeyMapping>stream(bindings).filter(b -> b.m_90862_()).toArray(x$0 -> new KeyMapping[x$0]);
//        }
//        return (KeyMapping[])Arrays.<KeyMapping>stream(bindings).filter(b -> (b.m_90858_() == category)).toArray(x$0 -> new KeyMapping[x$0]);
//    }

    public void tick() {
        updateList();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput p_259858_) {

    }

    public class BindingEntry extends AbstractSelectionList.Entry<BindingEntry> {
        private final KeyMapping keyBinding;

        public BindingEntry(KeyMapping keyBinding) {
            this.keyBinding = keyBinding;
        }

        @Override
        public void render(GuiGraphics graphics, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            String keyName = this.keyBinding.getName().substring(4);
            graphics.drawString(Minecraft.getInstance().font, keyName.substring(0, 1).toUpperCase() + keyName.substring(1), x, y, 0xFFFFFFFF);
            graphics.drawString(Minecraft.getInstance().font, this.keyBinding.getTranslatedKeyMessage(), x, (y + Minecraft.getInstance().font.lineHeight + 5), 0xFF999999);
        }
    }
}

