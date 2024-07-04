package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import xyz.gamars.eos.Eos;

public class TagInit {

    public static final TagKey<EntityType<?>> PIG_LIKE = createEntityTypeTag("pig_like");

    public static final TagKey<Item> POSEIDON_HELMET = createItemTag("poseidon_helmet");

    public static final TagKey<Enchantment> POSEIDON_LUCK = createEnchantmentTag("poseidon_luck");

    private static TagKey<EntityType<?>> createEntityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
    }

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
    }

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
    }

    private static TagKey<Enchantment> createEnchantmentTag(String name) {
        return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
    }

}
