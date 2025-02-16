package xyz.xindi.keywizard.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import xyz.xindi.keywizard.Keywizard;
import xyz.xindi.keywizard.util.KeyBindingUtil;

public class KeyWizardScreen extends OptionsSubScreen {
    private final int[] mouseCodes = new int[] {GLFW.GLFW_MOUSE_BUTTON_1, GLFW.GLFW_MOUSE_BUTTON_2, GLFW.GLFW_MOUSE_BUTTON_3, GLFW.GLFW_MOUSE_BUTTON_4, GLFW.GLFW_MOUSE_BUTTON_5, GLFW.GLFW_MOUSE_BUTTON_6, GLFW.GLFW_MOUSE_BUTTON_7, GLFW.GLFW_MOUSE_BUTTON_8};

    private int mouseCodeIndex = 0;

    private KeyboardWidget keyboard;

    private KeyboardWidget mouseButton;

    private Button mousePlus;

    private Button mouseMinus;

    private KeyBindingListWidget bindingList;

    private CategorySelectorWidget categorySelector;

    private ImageButton screenToggleButton;

    private EditBox searchBar;

    private Button resetBinding;

    private Button resetAll;

    private Button clearBinding;

    public KeyWizardScreen(Screen parent) {
        super(parent, Minecraft.getInstance().options, Component.nullToEmpty(Keywizard.MODID));
        LogUtils.getLogger().debug("KeyWizardScreen constructor");
    }

    @Override
    protected void init() {
        LogUtils.getLogger().debug("KeyWizardScreen init");
        int mouseButtonX = this.width - 105;
        int mouseButtonY = this.height / 2 - 115;
        int mouseButtonWidth = 80;
        int mouseButtonHeight = 20;
        int maxBindingNameWidth = 0;
        for (KeyMapping k : this.options.keyMappings) {
            LogUtils.getLogger().debug("KeyWizardScreen KeyMapping.name = " + k.getKey().getDisplayName());
            LogUtils.getLogger().debug("KeyWizardScreen KeyMapping.category = " + k.getCategory());
            int w = this.font.width((FormattedText) k.getTranslatedKeyMessage());
            if (w > maxBindingNameWidth)
                maxBindingNameWidth = w;
        }
        LogUtils.getLogger().debug("KeyWizardScreen maxBindingNameWidth = " + maxBindingNameWidth);
        int maxCategoryWidth = 0;
//        for (String s : KeyBindingUtil.getCategories()) {
//            LogUtils.getLogger().debug("KeyWizardScreen category = " + s);
////            int w = this.f_96547_.m_92852_((FormattedText)MutableComponent.create((ComponentContents)new TranslatableContents(s)));
////            if (w > maxCategoryWidth)
////                maxCategoryWidth = w;
//        }
        int bindingListWidth = maxBindingNameWidth + 20;
//        Objects.requireNonNull(this.f_96547_);
        this.bindingList = new KeyBindingListWidget(this, 10, 10, bindingListWidth, this.height - 40, 9 * 3 + 10);
        this.keyboard = KeyboardWidgetBuilder.standardKeyboard(this, (bindingListWidth + 15), (this.height / 2 - 90), (this.width - bindingListWidth + 15), 180.0F);
//        this.categorySelector = new CategorySelectorWidget(this, bindingListWidth + 15, 5, maxCategoryWidth + 20, 20);
//        this.screenToggleButton = new ImageButton(this.width - 22, this.height - 22, 20, 20, 20, 0, 20, KeyWizard.SCREEN_TOGGLE_WIDGETS, 40, 40, btn -> this.f_96541_.m_91152_((Screen)new ControlsScreen(this.f_96281_, this.f_96282_)));
//        this.searchBar = new EditBox(this.f_96547_, 10, this.height - 20, bindingListWidth, 14, Component.m_130674_(""));
//        this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);
//        this.mousePlus = new Button((int)this.mouseButton.getAnchorX() + 83, (int)this.mouseButton.getAnchorY(), 25, 20, Component.m_130674_("+"), btn -> {
//            this.mouseCodeIndex++;
//            if (this.mouseCodeIndex >= this.mouseCodes.length)
//                this.mouseCodeIndex = 0;
//            m_169411_((GuiEventListener)this.mouseButton);
//            this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);
//            m_142416_((GuiEventListener)this.mouseButton);
//        });
//        this.mouseMinus = new Button((int)this.mouseButton.getAnchorX() - 26, (int)this.mouseButton.getAnchorY(), 25, 20, Component.m_130674_("-"), btn -> {
//            this.mouseCodeIndex--;
//            if (this.mouseCodeIndex < 0)
//                this.mouseCodeIndex = this.mouseCodes.length - 1;
//            m_169411_((GuiEventListener)this.mouseButton);
//            this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);
//            m_142416_((GuiEventListener)this.mouseButton);
//        });
//        this.resetBinding = new Button(bindingListWidth + 15, this.height - 23, 50, 20, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents("controls.reset")), btn -> {
//            KeyMapping selectedBinding = getSelectedKeyBinding();
//            selectedBinding.m_90848_(selectedBinding.m_90861_());
//            KeyMapping.m_90854_();
//        });
//        this.clearBinding = new Button(bindingListWidth + 66, this.height - 23, 50, 20, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents("gui.clear")), btn -> {
//            KeyMapping selectedBinding = getSelectedKeyBinding();
//            selectedBinding.m_90848_(InputConstants.Type.KEYSYM.m_84895_(-1));
//            KeyMapping.m_90854_();
//        });

//        this.resetAll = new Button(bindingListWidth + 117, this.height - 23, 70, 20, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents("controls.resetAll")), btn -> {
//            for (KeyMapping b : this.f_96282_.f_92059_)
//                b.m_90848_(b.m_90861_());
//            KeyMapping.m_90854_();
//        });

        addRenderableWidget(this.bindingList);
//        addRenderableWidget(this.keyboard);
//        addWidget((GuiEventListener)this.categorySelector);
//        addWidget((GuiEventListener)this.categorySelector.getCategoryList());
//        addWidget((GuiEventListener)this.screenToggleButton);
//        addWidget((GuiEventListener)this.searchBar);
//        addWidget((GuiEventListener)this.mouseButton);
//        addWidget((GuiEventListener)this.mousePlus);
//        addWidget((GuiEventListener)this.mouseMinus);
//        addWidget((GuiEventListener)this.resetBinding);
//        addWidget((GuiEventListener)this.clearBinding);
//        addWidget((GuiEventListener)this.resetAll);
    }

    @Override
    protected void addOptions() {

    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
//        LogUtils.getLogger().debug("KeyWizardScreen render");
        renderTransparentBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void tick() {
        for (GuiEventListener e : this.children()) {
            if (e instanceof TickableElement)
                ((TickableElement)e).tick();
        }
    }

//    @Nullable
//    public KeyMapping getSelectedKeyBinding() {
//        return this.bindingList.getSelectedKeyBinding();
//    }
//
    public boolean getCategorySelectorExtended() {
        return true;
//        return this.categorySelector.extended;
    }
//
//    public String getSelectedCategory() {
//        return this.categorySelector.getSelctedCategory();
//    }
//
//    public String getFilterText() {
//        return this.searchBar.getValue();
//    }
//
//    public void setSearchText(String s) {
//        this.searchBar.setValue(s);
//    }
}
