package xyz.gamars.eos.common.objects;

import com.mojang.datafixers.types.templates.Tag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.enchantments.PoseidonLuckEnchantment;

import javax.swing.text.html.HTML;
import java.util.Optional;

public class EnchantmentInit {

    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT, Eos.MOD_ID);

    public static final DeferredHolder<Enchantment, Enchantment> BANE_OF_PIGS = ENCHANTMENTS.register("bane_of_pigs",
            () -> new DamageEnchantment(Enchantment.definition(
                    ItemTags.SHARP_WEAPON_ENCHANTABLE,
                    ItemTags.SWORD_ENCHANTABLE,
                    5,
                    5,
                    Enchantment.dynamicCost(5, 8),
                    Enchantment.dynamicCost(25, 8),
                    2,
                    EquipmentSlot.MAINHAND
                ), Optional.of(TagInit.PIG_LIKE)
            ));


    public static final DeferredHolder<Enchantment, Enchantment> POSEIDON_LUCK = ENCHANTMENTS.register("poseidon_luck",
            () -> new PoseidonLuckEnchantment(Enchantment.definition(
                    TagInit.POSEIDON_HELMET,
                     5,
                    5,
                    Enchantment.dynamicCost(5, 8),
                    Enchantment.dynamicCost(25, 8),
                    2,
                    EquipmentSlot.HEAD
                )

            ));



    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);

    }



}
