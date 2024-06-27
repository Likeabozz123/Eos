package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.gamars.eos.Eos;

public class TagInit {

    public static final TagKey<EntityType<?>> PIG_LIKE = createEntityTypeTag("pig_like");

    private static TagKey<EntityType<?>> createEntityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(Eos.MOD_ID, name));
    }

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(Eos.MOD_ID, name));
    }

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Eos.MOD_ID, name));
    }

}
