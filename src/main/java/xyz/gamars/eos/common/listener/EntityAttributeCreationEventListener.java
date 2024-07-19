package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.entities.monkey.MonkeyEntity;
import xyz.gamars.eos.common.objects.entities.punchingbag.PunchingBagEntity;
import xyz.gamars.eos.common.objects.entities.stoneegg.StoneEggEntity;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class EntityAttributeCreationEventListener {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(EntityTypeInit.STONE_EGG.get(), StoneEggEntity.createAttributes().build());
        event.put(EntityTypeInit.MONKEY.get(), MonkeyEntity.createAttributes().build());
        event.put(EntityTypeInit.PUNCHING_BAG.get(), PunchingBagEntity.createAttributes().build());
    }

}
