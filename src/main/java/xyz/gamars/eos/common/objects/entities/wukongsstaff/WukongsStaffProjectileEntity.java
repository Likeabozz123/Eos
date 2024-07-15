package xyz.gamars.eos.common.objects.entities.wukongsstaff;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.ItemInit;

public class WukongsStaffProjectileEntity extends AbstractArrow implements GeoEntity {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);


    public WukongsStaffProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public WukongsStaffProjectileEntity(LivingEntity owner, Level level, ItemStack pickupItemStack) {
        super(EntityTypeInit.WUKONGS_STAFF_PROJECTILE.get(), owner, level, pickupItemStack, pickupItemStack);
    }

    public WukongsStaffProjectileEntity(double x, double y, double z, Level level, ItemStack pickupItemStack) {
        super(EntityTypeInit.WUKONGS_STAFF_PROJECTILE.get(), x, y, z, level, pickupItemStack, pickupItemStack);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.WUKONGS_STAFF.get());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }
}
