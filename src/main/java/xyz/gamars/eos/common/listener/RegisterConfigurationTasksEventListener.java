package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterConfigurationTasksEvent;
import xyz.gamars.eos.Eos;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class RegisterConfigurationTasksEventListener {

    @SubscribeEvent
    public static void onRegisterConfigurationTask(RegisterConfigurationTasksEvent event) {

    }

}
