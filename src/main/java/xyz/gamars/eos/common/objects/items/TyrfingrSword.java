package xyz.gamars.eos.common.objects.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import xyz.gamars.eos.common.objects.ItemInit;

import java.util.List;

public class TyrfingrSword extends SwordItem {
    public TyrfingrSword(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }
}
