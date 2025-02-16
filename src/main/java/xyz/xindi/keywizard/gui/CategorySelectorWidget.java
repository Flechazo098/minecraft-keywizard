package xyz.xindi.keywizard.gui;

import xyz.xindi.keywizard.util.KeyBindingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;

import java.util.Objects;

public class CategorySelectorWidget
//        extends AbstractButton implements TickableElement
{
//    public KeyWizardScreen keyWizardScreen;
//
//    public boolean extended = false;
//
//    public BindingCategoryListWidget categoryList;
//
//    public CategorySelectorWidget(KeyWizardScreen keyWizardScreen, int x, int y, int width, int height) {
//        super(x, y, width, height, Component.m_130674_(""));
//        this.keyWizardScreen = keyWizardScreen;
//        Minecraft c = Minecraft.getInstance();
//        Objects.requireNonNull(c.f_91062_);
//        int listItemHeight = 9 + 7;
//        int listHeight = KeyBindingUtil.getCategoriesWithDynamics().size() * listItemHeight + 10;
//        int listBottom = this.f_93621_ + this.f_93619_ + listHeight;
//        if (listBottom > this.keyWizardScreen.f_96544_)
//            listHeight = this.keyWizardScreen.f_96544_ - this.f_93621_ - this.f_93619_ - 10;
//        this.categoryList = new BindingCategoryListWidget(c, this.f_93621_ + this.f_93619_, this.f_93620_, this.f_93618_, listHeight, listItemHeight);
//    }
//
//    public boolean m_6375_(double mouseX, double mouseY, int button) {
//        boolean listClicked = this.categoryList.m_6375_(mouseX, mouseY, button);
//        boolean thisClicked = super.m_6375_(mouseX, mouseY, button);
//        if (!listClicked && !thisClicked)
//            this.extended = false;
//        return (listClicked || thisClicked);
//    }
//
//    public void m_5691_() {
//        m_7435_(Minecraft.m_91087_().m_91106_());
//        this.extended = !this.extended;
//    }
//
//    public void m_6305_(PoseStack matrices, int mouseX, int mouseY, float delta) {
//        super.m_6305_(matrices, mouseX, mouseY, delta);
//        this.categoryList.m_6305_(matrices, mouseX, mouseY, delta);
//    }
//
//    public void tick() {
//        m_93666_((Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents(getSelctedCategory())));
//        this.categoryList.visible = this.extended;
//    }
//
//    public String getSelctedCategory() {
//        if (this.categoryList.m_93511_() == null)
//            return "key.categories.keywizard.all";
//        return ((BindingCategoryListWidget.CategoryEntry)this.categoryList.m_93511_()).category;
//    }
//
//    public BindingCategoryListWidget getCategoryList() {
//        return this.categoryList;
//    }
//
//    private class BindingCategoryListWidget extends FreeFormListWidget<BindingCategoryListWidget.CategoryEntry> {
//        public BindingCategoryListWidget(Minecraft client, int top, int left, int width, int height, int itemHeight) {
//            super(client, top, left, width, height, itemHeight);
//            for (String c : KeyBindingUtil.getCategoriesWithDynamics())
//                m_7085_(new CategoryEntry(c));
//            m_6987_(m_6702_().get(0));
//        }
//
//        public class CategoryEntry extends FreeFormListWidget<CategoryEntry>.Entry {
//            private final String category;
//
//            public CategoryEntry(String category) {
//                this.category = category;
//            }
//
//            public void m_6311_(PoseStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
//                CategorySelectorWidget.BindingCategoryListWidget.this.f_93386_.f_91062_.m_92763_(matrices, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents(this.category)), (x + 3), (y + 2), -1);
//            }
//        }
//
//        public void m_142291_(NarrationElementOutput var1) {}
//    }
//
//    public class CategoryEntry extends FreeFormListWidget<BindingCategoryListWidget.CategoryEntry>.Entry {
//        private final String category;
//
//        public CategoryEntry(String category) {
//            this.category = category;
//        }
//
//        public void m_6311_(PoseStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
//            CategorySelectorWidget.BindingCategoryListWidget.this.f_93386_.f_91062_.m_92763_(matrices, (Component)MutableComponent.m_237204_((ComponentContents)new TranslatableContents(this.category)), (x + 3), (y + 2), -1);
//        }
//    }
//
//    public void m_142291_(NarrationElementOutput var1) {}
}

