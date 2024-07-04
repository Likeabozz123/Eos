package xyz.gamars.eos.client.listeners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.client.KeyMappingInit;

@EventBusSubscriber(modid = Eos.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class RegisterKeyMappingsEventListener {

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(KeyMappingInit.WHIP_OUT_STAFF.get());
    }

}
