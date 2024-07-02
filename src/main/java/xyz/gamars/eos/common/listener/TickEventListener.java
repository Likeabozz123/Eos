package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import xyz.gamars.eos.Eos;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class TickEventListener{

    @SubscribeEvent
    public static void onTick(EntityTickEvent.Post event) {

    }

}
