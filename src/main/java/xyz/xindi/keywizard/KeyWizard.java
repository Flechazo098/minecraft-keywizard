package xyz.xindi.keywizard;

import net.minecraft.resources.ResourceLocation;
import xyz.xindi.keywizard.event.ClientEventHandler;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KeyWizard.MODID)
public class KeyWizard {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "keywizard";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ResourceLocation SCREEN_TOGGLE_WIDGETS = ResourceLocation.fromNamespaceAndPath("keywizard", "textures/gui/screen_toggle_widgets.png");

    public KeyWizard(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.debug("keywizard commonSetup");
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }
}
