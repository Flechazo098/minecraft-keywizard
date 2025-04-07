package xyz.xindi.keywizard.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;
import xyz.xindi.keywizard.gui.KeyWizardScreen;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class ClientEventHandler {
    public static final KeyMapping KEY_OPEN_KEYWIZARD = new KeyMapping("key.keywizard.openKeyWizard", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F7, "key.categories.keywizard.bindings");

    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent e) {
        e.register(KEY_OPEN_KEYWIZARD);
    }

//    public void onKeyInput(InputEvent e) {
    public void onClientTick(ClientTickEvent.Post e) {
        if (KEY_OPEN_KEYWIZARD.isDown()) {
            Minecraft client = Minecraft.getInstance();
            client.setScreen((Screen)new KeyWizardScreen(client.screen));
        }
    }
}
