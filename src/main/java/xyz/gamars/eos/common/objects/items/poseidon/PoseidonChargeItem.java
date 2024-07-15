package xyz.gamars.eos.common.objects.items.poseidon;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WindChargeItem;
import net.minecraft.world.level.Level;

public class PoseidonChargeItem extends WindChargeItem {

    public PoseidonChargeItem(Properties p_326377_) {
        super(p_326377_);
    }

    public InteractionResultHolder<ItemStack> use(Level p_326306_, Player p_326042_, InteractionHand p_326470_) {
        if (!p_326306_.isClientSide()) {
            WindCharge windcharge = new WindCharge(p_326042_, p_326306_, p_326042_.position().x(), p_326042_.getEyePosition().y(), p_326042_.position().z());
            windcharge.shootFromRotation(p_326042_, p_326042_.getXRot(), p_326042_.getYRot(), 0.0F, 1.5F, 1.0F);
            p_326306_.addFreshEntity(windcharge);
        }

        p_326306_.playSound(
                null,
                p_326042_.getX(),
                p_326042_.getY(),
                p_326042_.getZ(),
                SoundEvents.WIND_CHARGE_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (p_326306_.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        ItemStack itemstack = p_326042_.getItemInHand(p_326470_);
        p_326042_.getCooldowns().addCooldown(this, 10);
        p_326042_.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, p_326042_);
        return InteractionResultHolder.sidedSuccess(itemstack, p_326306_.isClientSide());
    }

}
