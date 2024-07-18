package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.ItemInit;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class PlayerAttackEventListener {

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        ItemInit.GOD_SLAYER.get().onPlayerAttack(event);
    }

}
