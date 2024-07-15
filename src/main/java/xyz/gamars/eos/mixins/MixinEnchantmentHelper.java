package xyz.gamars.eos.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.gamars.eos.data.providers.EosEnchantmentDataProvider;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {

    @Inject(method = "getFishingLuckBonus(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/Entity;)I",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;runIterationOnItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/enchantment/EnchantmentHelper$EnchantmentVisitor;)V"))
    private static void getFishingLuckBonus(ServerLevel level, ItemStack stack, Entity entity, CallbackInfoReturnable<Integer> cir, @Local MutableFloat mutableFloat) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            RegistryAccess registryAccess = level.registryAccess();

            Holder<Enchantment> poseidonLuck = registryAccess.holderOrThrow(EosEnchantmentDataProvider.POSEIDON_LUCK);
            ItemEnchantments itemEnchantments = livingEntity.getItemBySlot(EquipmentSlot.HEAD).getAllEnchantments(registryAccess.lookupOrThrow(Registries.ENCHANTMENT));
            mutableFloat.add(itemEnchantments.getLevel(poseidonLuck));
        }
    }

}
