package xyz.gamars.eos.client.listeners;

import com.mojang.blaze3d.platform.InputConstants;
import com.sun.jna.platform.win32.WinNT;
import cpw.mods.util.Lazy;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.client.KeyMappingInit;

@EventBusSubscriber(modid = Eos.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class RegisterKeyMappingsEventListener {

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(KeyMappingInit.WHIP_OUT_STAFF.get());
    }

}
