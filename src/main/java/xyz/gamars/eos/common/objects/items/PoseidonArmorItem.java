package xyz.gamars.eos.common.objects.items;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.gamars.eos.common.objects.ItemInit;

import java.util.ArrayList;

public class PoseidonArmorItem extends ArmorItem {


    public PoseidonArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotID, boolean isSelected) {
        if (!level.isClientSide()) {
            LivingEntity livingEntity = (LivingEntity) entity;
            ArrayList<ItemStack> armorSlots = new ArrayList<>();
            livingEntity.getArmorSlots().forEach(armorSlots::add);

            if (armorSlots.get(3).is(ItemInit.POSEIDON_HELMET.get())
                    && armorSlots.get(2).is(ItemInit.POSEIDON_CHESTPLATE.get())
                    && armorSlots.get(1).is(ItemInit.POSEIDON_LEGGINGS.get())
                    && armorSlots.get(0).is(ItemInit.POSEIDON_BOOTS.get())) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false));
            }
        }

        super.inventoryTick(itemStack, level, entity, slotID, isSelected);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
