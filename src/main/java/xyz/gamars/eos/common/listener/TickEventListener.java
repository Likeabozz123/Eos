package xyz.gamars.eos.common.listener;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.ItemInit;

import java.util.ArrayList;

@EventBusSubscriber(modid = Eos.MOD_ID)
public class TickEventListener{

    @SubscribeEvent
    public static void onTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntity();
            ArrayList<ItemStack> armorSlots = new ArrayList<>();
            entity.getArmorSlots().forEach(armorSlots::add);

            if (armorSlots.get(3).is(ItemInit.POSEIDON_HELMET.get())
                    && armorSlots.get(2).is(ItemInit.POSEIDON_CHESTPLATE.get())
                    && armorSlots.get(1).is(ItemInit.POSEIDON_LEGGINGS.get())
                    && armorSlots.get(0).is(ItemInit.POSEIDON_BOOTS.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false));
            }

        }
    }

}
