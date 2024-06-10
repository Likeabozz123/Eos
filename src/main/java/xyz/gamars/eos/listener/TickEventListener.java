package xyz.gamars.eos.listener;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.objects.ItemInit;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class TickEventListener{

    @SubscribeEvent
    public static void onTick(EntityTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide()) {

            if (event.getEntity() instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) event.getEntity();
                if (entity instanceof Player) {
                    Player player = (Player) entity;
                    if (player.swingTime == 1) {
                        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.PLUNGER)) {
                            player.level().explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
                        }
                    }
                }
            }

        }
    }

}
