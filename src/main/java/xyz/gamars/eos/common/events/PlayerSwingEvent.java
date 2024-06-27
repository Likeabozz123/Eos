package xyz.gamars.eos.common.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class PlayerSwingEvent extends LivingEvent {

    private final int swingingTime;
    private final InteractionHand hand;

    public PlayerSwingEvent(LivingEntity entity, int swingingTime, InteractionHand hand) {
        super(entity);
        this.swingingTime = swingingTime;
        this.hand = hand;
    }

    public int getSwingingTime() {
        return swingingTime;
    }

    public InteractionHand getHand() {
        return hand;
    }
}
