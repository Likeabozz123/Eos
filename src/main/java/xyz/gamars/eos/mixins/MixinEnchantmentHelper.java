package xyz.gamars.eos.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.data.providers.EosEnchantmentDataProvider;

import java.util.ArrayList;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {

    @Inject(method = "getFishingLuckBonus(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/Entity;)I",
            at = @At("RETURN"))
    private static void getFishingLuckBonus(ServerLevel level, ItemStack stack, Entity entity, CallbackInfoReturnable<Integer> cir, @Local MutableFloat mutableFloat) {
        ArrayList<ItemStack> armor = new ArrayList<>();
        Player player = (Player) entity;
        RegistryAccess registryAccess = level.registryAccess();
        player.getArmorSlots().forEach(armor::add);

        Holder<Enchantment> poseidonLuck = registryAccess.holderOrThrow(EosEnchantmentDataProvider.POSEIDON_LUCK);
        ItemEnchantments itemEnchantments = armor.get(3).getAllEnchantments(registryAccess.lookupOrThrow(Registries.ENCHANTMENT));
        if (itemEnchantments.keySet().contains(poseidonLuck)) {
            mutableFloat.add(itemEnchantments.getLevel(poseidonLuck));
            Eos.LOGGER.info(mutableFloat.toString());
        }
    }

}
