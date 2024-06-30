package xyz.gamars.eos.common.objects.enchantments;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;

import java.util.Set;

public class PoseidonLuckEnchantment extends LootBonusEnchantment {

    public PoseidonLuckEnchantment(EnchantmentDefinition pDefinition) {
        super(pDefinition);
    }

    @Override
    public boolean allowedInCreativeTabw(Item book, Set<TagKey<Item>> allowedCategories) {
        return true;
    }


}
