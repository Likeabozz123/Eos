package xyz.gamars.eos.utils;

import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class InventoryUtils {


    public static boolean isInventoryFull(NonNullList<ItemStack> items) {
        for (ItemStack item : items) {
            if (item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void modifyItemAttribute(ItemStack item, Holder<Attribute> attribute, AttributeModifier attributeModifier, EquipmentSlotGroup equipmentSlotGroup) {
        ItemAttributeModifiers currentAttributes = item.get(DataComponents.ATTRIBUTE_MODIFIERS);
        ItemAttributeModifiers.Builder newAttributes = ItemAttributeModifiers.builder();

        currentAttributes.modifiers().forEach( modifier -> {
            if (modifier.attribute().equals(attribute)) {
                newAttributes.add(attribute, attributeModifier, equipmentSlotGroup);
            } else {
                newAttributes.add(modifier.attribute(), modifier.modifier(), modifier.slot());
            }
        });
        item.set(DataComponents.ATTRIBUTE_MODIFIERS, newAttributes.build());
    }

}
