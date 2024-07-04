package xyz.gamars.eos.common.objects.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import xyz.gamars.eos.common.objects.ItemInit;

import java.util.ArrayList;

public class PoseidonTridentItem extends TridentItem {

    public PoseidonTridentItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {

        if (!damageSource.getEntity().level().isClientSide) {
            LivingEntity livingEntity = (LivingEntity) damageSource.getEntity();
            ArrayList<ItemStack> armorSlots = new ArrayList<>();
            livingEntity.getArmorSlots().forEach(armorSlots::add);

            if (armorSlots.get(3).is(ItemInit.POSEIDON_HELMET.get())
                    && armorSlots.get(2).is(ItemInit.POSEIDON_CHESTPLATE.get())
                    && armorSlots.get(1).is(ItemInit.POSEIDON_LEGGINGS.get())
                    && armorSlots.get(0).is(ItemInit.POSEIDON_BOOTS.get())) {
                return damage * 2;
            }
        }

        return super.getAttackDamageBonus(target, damage, damageSource);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {

        if (!entity.level().isClientSide) {
            LivingEntity livingEntity = (LivingEntity) entity;
            ArrayList<ItemStack> armorSlots = new ArrayList<>();
            livingEntity.getArmorSlots().forEach(armorSlots::add);

            if (armorSlots.get(3).is(ItemInit.POSEIDON_HELMET.get())
                    && armorSlots.get(2).is(ItemInit.POSEIDON_CHESTPLATE.get())
                    && armorSlots.get(1).is(ItemInit.POSEIDON_LEGGINGS.get())
                    && armorSlots.get(0).is(ItemInit.POSEIDON_BOOTS.get())) {

                itemStack.set(DataComponents.ATTRIBUTE_MODIFIERS,
                        ItemAttributeModifiers.builder()
                                .add(
                                        Attributes.ATTACK_DAMAGE,
                                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 16.0f, AttributeModifier.Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .add(
                                        Attributes.ATTACK_SPEED,
                                        new AttributeModifier(BASE_ATTACK_SPEED_ID,  0f, AttributeModifier.Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .build());



            } else {
                itemStack.set(DataComponents.ATTRIBUTE_MODIFIERS,
                        ItemAttributeModifiers.builder()
                                .add(
                                        Attributes.ATTACK_DAMAGE,
                                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 0f, AttributeModifier.Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .add(
                                        Attributes.ATTACK_SPEED,
                                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.0f, AttributeModifier.Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .build());
            }
        }

        super.inventoryTick(itemStack, pLevel, entity, pSlotId, pIsSelected);
    }


    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 1.0, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.0F, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}
