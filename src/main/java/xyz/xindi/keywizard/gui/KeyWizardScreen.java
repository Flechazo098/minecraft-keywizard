package xyz.xindi.keywizard.gui;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import xyz.xindi.keywizard.KeyWizard;

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
        super(parent, Minecraft.getInstance().options, Component.nullToEmpty(KeyWizard.MODID));
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
        int maxCategoryWidth = 0;
        for (KeyMapping k : this.options.keyMappings) {
            LogUtils.getLogger().debug("KeyWizardScreen KeyMapping.name = " + k.getKey().getDisplayName());
            LogUtils.getLogger().debug("KeyWizardScreen KeyMapping.category = " + k.getCategory());
            int w = this.font.width(MutableComponent.create(new TranslatableContents(k.getName(), k.getName(), new Object[]{})));
            if (w > maxBindingNameWidth)
                maxBindingNameWidth = w;

            int categoryWidth = this.font.width(k.getCategory());
            if (categoryWidth > maxCategoryWidth)
                maxCategoryWidth = categoryWidth;
        }
        LogUtils.getLogger().debug("KeyWizardScreen maxBindingNameWidth = " + maxBindingNameWidth);
        LogUtils.getLogger().debug("KeyWizardScreen maxCategoryWidth = " + maxCategoryWidth);

        int bindingListWidth = maxBindingNameWidth + 20;

        this.keyboard = KeyboardWidgetBuilder.standardKeyboard(this, (bindingListWidth + 15), (this.height / 2 - 90), (this.width - bindingListWidth -15), 180.0F);
        this.bindingList = new KeyBindingListWidget(this, 10, 10, bindingListWidth, this.height - 40, 9 * 3 + 10);
        this.categorySelector = new CategorySelectorWidget(this, bindingListWidth + 15, 5, maxCategoryWidth + 50, 20);

        this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);

        Button.Builder mousePlusBuilder = new Button.Builder(Component.translatable("+"), btn -> {});
        mousePlusBuilder.bounds((int)this.mouseButton.getAnchorX() + 83, (int)this.mouseButton.getAnchorY(), 25, 20);
        this.mousePlus = mousePlusBuilder.build();
//        this.mousePlus = new Button((int)this.mouseButton.getAnchorX() + 83, (int)this.mouseButton.getAnchorY(), 25, 20, Component.m_130674_("+"), btn -> {
//            this.mouseCodeIndex++;
//            if (this.mouseCodeIndex >= this.mouseCodes.length)
//                this.mouseCodeIndex = 0;
//            m_169411_((GuiEventListener)this.mouseButton);
//            this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);
//            m_142416_((GuiEventListener)this.mouseButton);
//        });

        Button.Builder mouseMinusBuilder = new Button.Builder(Component.translatable("-"), btn -> {});
        mouseMinusBuilder.bounds((int)this.mouseButton.getAnchorX() - 26, (int)this.mouseButton.getAnchorY(), 25, 20);
        this.mouseMinus = mouseMinusBuilder.build();
//        this.mouseMinus = new Button((int)this.mouseButton.getAnchorX() - 26, (int)this.mouseButton.getAnchorY(), 25, 20, Component.m_130674_("-"), btn -> {
//            this.mouseCodeIndex--;
//            if (this.mouseCodeIndex < 0)
//                this.mouseCodeIndex = this.mouseCodes.length - 1;
//            m_169411_((GuiEventListener)this.mouseButton);
//            this.mouseButton = KeyboardWidgetBuilder.singleKeyKeyboard(this, mouseButtonX, mouseButtonY, mouseButtonWidth, mouseButtonHeight, this.mouseCodes[this.mouseCodeIndex], InputConstants.Type.MOUSE);
//            m_142416_((GuiEventListener)this.mouseButton);
//        });

        this.searchBar = new EditBox(this.font, 10, this.height - 20, bindingListWidth, 14, Component.empty());

        Button.Builder resetBindingBuilder = new Button.Builder(MutableComponent.create(new TranslatableContents("controls.reset", "controls.reset", new Object[]{})), btn -> {});
        resetBindingBuilder.bounds(bindingListWidth + 15, this.height - 23, 50, 20);
        this.resetBinding = resetBindingBuilder.build();
//        this.resetBinding = new Button(bindingListWidth + 15, this.height - 23, 50, 20, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents("controls.reset")), btn -> {
//            KeyMapping selectedBinding = getSelectedKeyBinding();
//            selectedBinding.m_90848_(selectedBinding.m_90861_());
//            KeyMapping.m_90854_();
//        });

        Button.Builder clearBindingBuilder = new Button.Builder(MutableComponent.create(new TranslatableContents("gui.clear", "gui.clear", new Object[]{})), btn -> {});
        clearBindingBuilder.bounds(bindingListWidth + 66, this.height - 23, 50, 20);
        this.clearBinding = clearBindingBuilder.build();
//        this.clearBinding = new Button(bindingListWidth + 66, this.height - 23, 50, 20, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents("gui.clear")), btn -> {
//            KeyMapping selectedBinding = getSelectedKeyBinding();
//            selectedBinding.m_90848_(InputConstants.Type.KEYSYM.m_84895_(-1));
//            KeyMapping.m_90854_();
//        });

        Button.Builder resetAllBuilder = new Button.Builder(MutableComponent.create(new TranslatableContents("controls.resetAll", "controls.resetAll", new Object[]{})), btn -> {});
        resetAllBuilder.bounds(bindingListWidth + 117, this.height - 23, 70, 20);
        this.resetAll = resetAllBuilder.build();
//        this.resetAll = new Button(bindingListWidth + 117, this.height - 23, 70, 20, (Component)MutableComponent.create((ComponentContents)new TranslatableContents("controls.resetAll", "controls.resetAll", new Object[]{})), btn -> {
////            for (KeyMapping b : this.f_96282_.f_92059_)
////                b.m_90848_(b.m_90861_());
////            KeyMapping.m_90854_();
//        }, val -> {
//            return Component.empty();
//        });

        this.screenToggleButton = new ImageButton(this.width - 22, this.height - 22, 20, 20, new WidgetSprites(KeyWizard.SCREEN_TOGGLE_WIDGETS, KeyWizard.SCREEN_TOGGLE_WIDGETS), btn -> {
            this.minecraft.setScreen((Screen) new ControlsScreen(this.lastScreen, this.options));
        });

        addRenderableWidget(this.bindingList);
        addRenderableWidget(this.keyboard);
        addRenderableWidget(this.categorySelector);
        addRenderableWidget(this.categorySelector.getCategoryList());

        addRenderableWidget(this.mouseButton);
        addRenderableWidget(this.mousePlus);
        addRenderableWidget(this.mouseMinus);

        addRenderableWidget(this.searchBar);
        addRenderableWidget(this.resetBinding);
        addRenderableWidget(this.clearBinding);
        addRenderableWidget(this.resetAll);
        addRenderableWidget(this.screenToggleButton);
    }

    @Override
    protected void addOptions() {

    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
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

    public boolean getCategorySelectorExtended() {
        return this.categorySelector.extended;
    }

    public String getSelectedCategory() {
        return this.categorySelector.getSelctedCategory();
    }

    public String getFilterText() {
        return this.searchBar.getValue();
    }

    public void setSearchText(String s) {
        this.searchBar.setValue(s);
    }
}
