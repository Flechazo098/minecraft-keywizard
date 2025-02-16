package xyz.xindi.keywizard.util;


import xyz.xindi.keywizard.mixin.KeyBindingAccessor;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyBindingUtil {
    public static final String DYNAMIC_CATEGORY_ALL = "key.categories.keywizard.all";

    public static final String DYNAMIC_CATEGORY_CONFLICTS = "key.categories.keywizard.conflicts";

    public static final String DYNAMIC_CATEGORY_UNBOUND = "key.categories.keywizard.unbound";

    public static ArrayList<String> getCategories() {
        return (ArrayList<String>) KeyBindingAccessor.getKeyCategories().stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<String> getCategoriesWithDynamics() {
        ArrayList<String> categories = getCategories();
        categories.add(0, "key.categories.keywizard.unbound");
        categories.add(0, "key.categories.keywizard.conflicts");
        categories.add(0, "key.categories.keywizard.all");
        return categories;
    }

    public static Map<InputConstants.Key, Integer> getBindingCountsByKey() {
        HashMap<InputConstants.Key, Integer> map = new HashMap<>();
        for (KeyMapping b : (Minecraft.getInstance()).options.keyMappings)
            map.merge(((KeyBindingAccessor)b).getBoundKey(), Integer.valueOf(1), Integer::sum);
        return Collections.unmodifiableMap(map);
    }
}
