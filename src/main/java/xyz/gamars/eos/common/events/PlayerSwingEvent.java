package xyz.gamars.eos.common.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class PlayerSwingEvent extends PlayerEvent {

    private final int swingingTime;
    private final Level level;
    private final ItemStack itemSwung;

    public PlayerSwingEvent(Player player, int swingingTime) {
        super(player);
        this.swingingTime = swingingTime;
        this.level = player.level();
        this.itemSwung = player.getItemInHand(InteractionHand.MAIN_HAND);
    }

    public int getSwingingTime() {
        return swingingTime;
    }


    public Level getLevel() {
        return level;
    }

    public ItemStack getItemSwung() {
        return itemSwung;
    }
}
