package xyz.gamars.eos.data.providers;

import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.ApplyMobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.TagInit;

public class EosEnchantmentDataProvider {

    public static final ResourceKey<Enchantment> BANE_OF_PIGS = create("bane_of_pigs");
    public static final ResourceKey<Enchantment> POSEIDON_LUCK = create("poseidon_luck");


    public static void enchantments(BootstrapContext<Enchantment> bootstrap) {

        HolderGetter<DamageType> damageTypeRegistry = bootstrap.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> enchantmentRegistry = bootstrap.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> itemRegistry = bootstrap.lookup(Registries.ITEM);
        HolderGetter<Block> blockRegistry = bootstrap.lookup(Registries.BLOCK);

        register(bootstrap,
                BANE_OF_PIGS,
                Enchantment.enchantment(Enchantment.definition(
                itemRegistry.getOrThrow(ItemTags.SHARP_WEAPON_ENCHANTABLE),
                itemRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                5,
                Enchantment.dynamicCost(5, 8),
                Enchantment.dynamicCost(25, 8),
                2,
                EquipmentSlotGroup.MAINHAND
            )).exclusiveWith(enchantmentRegistry.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                        .withEffect(
                                EnchantmentEffectComponents.DAMAGE,
                                new AddValue(LevelBasedValue.perLevel(2.5F)),
                                LootItemEntityPropertyCondition.hasProperties(
                                        LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(TagInit.PIG_LIKE))
                                )
                        )
                        .withEffect(
                                EnchantmentEffectComponents.POST_ATTACK,
                                EnchantmentTarget.ATTACKER,
                                EnchantmentTarget.VICTIM,
                                new ApplyMobEffect(
                                        HolderSet.direct(MobEffects.MOVEMENT_SLOWDOWN),
                                        LevelBasedValue.constant(1.5F),
                                        LevelBasedValue.perLevel(1.5F, 0.5F),
                                        LevelBasedValue.constant(3.0F),
                                        LevelBasedValue.constant(3.0F)
                                ),
                                LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS,
                                                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(TagInit.PIG_LIKE))
                                        )
                                        .and(DamageSourceCondition.hasDamageSource(DamageSourcePredicate.Builder.damageType().isDirect(true)))
                        )
        );

        register(bootstrap,
                POSEIDON_LUCK,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemRegistry.getOrThrow(TagInit.POSEIDON_HELMET),
                                        2,
                                        3,
                                        Enchantment.dynamicCost(15, 9),
                                        Enchantment.dynamicCost(65, 9),
                                        4,
                                        EquipmentSlotGroup.MAINHAND
                                )
                        )
                        .withEffect(EnchantmentEffectComponents.FISHING_LUCK_BONUS, new AddValue(LevelBasedValue.perLevel(1.0F))));

    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }
    private static ResourceKey<Enchantment> create(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, id));
    }



}
