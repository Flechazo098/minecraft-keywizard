package xyz.xindi.keywizard.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin({KeyMapping.class})
public interface KeyBindingAccessor {
    @Accessor
    InputConstants.Key getBoundKey();

    @Accessor("KEY_CATEGORIES")
    static Set<String> getKeyCategories() {
        throw new AssertionError();
    }
}
