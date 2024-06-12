package xyz.gamars.eos.listener;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.events.PlayerSwingEvent;
import xyz.gamars.eos.objects.ItemInit;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class PlayerSwingEventListener {

    @SubscribeEvent
    public static void onPlayerSwing(PlayerSwingEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            if (event.getEntity() instanceof LivingEntity) {
                Player player = (Player) event.getEntity();
                if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.PLUNGER)) {
                    player.level().explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
                }
            }

        }
    }
}
