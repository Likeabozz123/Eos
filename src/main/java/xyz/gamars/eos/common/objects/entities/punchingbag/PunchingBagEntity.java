package xyz.gamars.eos.common.objects.entities.punchingbag;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.checkerframework.checker.units.qual.A;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.Collections;

public class PunchingBagEntity extends LivingEntity implements GeoEntity {

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    protected static final RawAnimation ATTACKED = RawAnimation.begin().thenPlay("attacked");

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    private boolean attacked = false;


    public PunchingBagEntity(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        setAnimData(DataTickets.ACTIVE, true);

    }

    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, Double.MAX_VALUE)
                .add(Attributes.KNOCKBACK_RESISTANCE, Double.MAX_VALUE);
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        ArrayList<ItemStack> armor = new ArrayList<>();
        armor.add(ItemStack.EMPTY);
        return armor;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // controllers.add(new AnimationController<>(this, "attacked", 0, this::attackedAnimController));
        controllers.add(new AnimationController<>(this, "attacked_controller", event -> PlayState.STOP)
                .triggerableAnim("attacked", ATTACKED)
        );
    }

    protected <E extends PunchingBagEntity> PlayState attackedAnimController(final AnimationState<E> event) {

        if (event.getController().hasAnimationFinished()) {
            attacked = false;
        }

        if (attacked) {
            return event.setAndContinue(ATTACKED);
        }

        event.getController().forceAnimationReset();

        return PlayState.STOP;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        triggerAnim("attacked_controller", "attacked");
        setCustomName(Component.literal("Damage: " + amount + " / Health: " + getHealth()));
        setHealth((float) Double.MAX_VALUE);
        return super.hurt(source, amount);
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

}
