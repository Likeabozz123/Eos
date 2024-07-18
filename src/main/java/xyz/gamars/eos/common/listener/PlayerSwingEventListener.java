package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.common.objects.ItemInit;


@EventBusSubscriber(modid = Eos.MOD_ID)
public class PlayerSwingEventListener {


    @SubscribeEvent
    public static void onPlayerSwing(PlayerSwingEvent event) {

        ItemInit.COOL_ASS_STICK.get().onPlayerSwing(event);
        ItemInit.PLUNGER.get().onPlayerSwing(event);
        ItemInit.TYRFINGER_SWORD.get().onPlayerSwing(event);
        ItemInit.POSEIDON_TRIDENT.get().onPlayerSwing(event);
        ItemInit.BIG_BOB.get().onPlayerSwing(event);

    }
}
