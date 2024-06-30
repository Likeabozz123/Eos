package xyz.gamars.eos.common.objects.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.common.objects.ItemInit;

public class PlungerItem extends Item {

    public PlungerItem(Properties properties) {
        super(properties);
    }

    public void onPlayerSwing(PlayerSwingEvent event) {
        if (event.getItemSwung().is(this)) {
            Player player = event.getEntity();
            if (!event.getLevel().isClientSide()) {
                event.getLevel().explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
            }
        }
    }

}
