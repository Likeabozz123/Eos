package xyz.gamars.eos.common.objects.entities.wukongsstaff;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.ItemInit;
import xyz.gamars.eos.utils.InventoryUtils;

import javax.annotation.Nullable;

public class WukongsStaffProjectileEntity extends AbstractArrow implements GeoEntity, IEntityWithComplexSpawn {

    private boolean dealtDamage;

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
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        return entity == null || !entity.isAlive() ? false : !(entity instanceof ServerPlayer) || !entity.isSpectator();
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        float damage = (float) InventoryUtils.getItemAttribute(getPickupItemStackOrigin(), Attributes.ATTACK_DAMAGE).modifier().amount() + 1;
        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, (Entity)(entity1 == null ? this : entity1));
        if (this.level() instanceof ServerLevel serverlevel) {
            damage = EnchantmentHelper.modifyDamage(serverlevel, this.getWeaponItem(), entity, damagesource, damage);
        }

        this.dealtDamage = true;
        if (entity.hurt(damagesource, damage)) {
            if (this.level() instanceof ServerLevel serverLevel) {
                EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, entity, damagesource, this.getWeaponItem());
            }

            if (entity instanceof LivingEntity livingentity) {
                this.doKnockback(livingentity, damagesource);
                this.doPostHurtEffects(livingentity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        this.playSound(SoundEvents.GENERIC_EXPLODE.value(), 1.0F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    @Override
    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
        buffer.writeInt(this.getPickupItemStackOrigin().get(DataComponentsInit.SIZE.get()).size());
    }

    @Override
    public void readSpawnData(RegistryFriendlyByteBuf buffer) {
        int size = buffer.readInt();
        getPickupItemStackOrigin().set(DataComponentsInit.SIZE.get(), new SizeComponent(size));
    }

    public int getSize() {
        return getPickupItemStackOrigin().get(DataComponentsInit.SIZE.get()).size();
    }
}
