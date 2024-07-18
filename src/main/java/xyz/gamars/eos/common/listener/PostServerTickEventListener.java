package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.ItemInit;


@EventBusSubscriber(modid = Eos.MOD_ID)
public class PostServerTickEventListener {

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        ItemInit.BIG_BOB.get().onServerTick(event);
    }

}
