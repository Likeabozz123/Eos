package xyz.gamars.eos.common.events;

import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class PlayerUseEvent extends LivingEvent {

    private final Interaction rightClick;


    public PlayerUseEvent(LivingEntity entity, Interaction rightClick) {
        super(entity);
        this.rightClick = rightClick;
    }

    public Interaction getRightClick() {
        return rightClick;
    }


}
