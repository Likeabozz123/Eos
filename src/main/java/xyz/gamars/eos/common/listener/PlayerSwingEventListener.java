package xyz.gamars.eos.common.listener;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.common.objects.ItemInit;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class PlayerSwingEventListener {

    @SubscribeEvent
    public static void onPlayerSwing(PlayerSwingEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.PLUNGER)) {
                    player.level().explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
                }
            }

        }
    }
}
