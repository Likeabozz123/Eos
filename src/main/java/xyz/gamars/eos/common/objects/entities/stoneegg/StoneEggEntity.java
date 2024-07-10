package xyz.gamars.eos.common.objects.entities.stoneegg;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import xyz.gamars.eos.common.objects.EntityTypeInit;

public class StoneEggEntity extends Mob implements GeoEntity {

    protected static final RawAnimation ROCKING = RawAnimation.begin().thenLoop("rocking");

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    private boolean interacted = false;

    public StoneEggEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public StoneEggEntity(Level level) {
        super(EntityTypeInit.STONE_EGG.get(), level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "hatching", 0, this::hatchingAnimController));
    }

    protected <E extends StoneEggEntity> PlayState hatchingAnimController(final AnimationState<E> event) {
        if (interacted) {
            return event.setAndContinue(ROCKING);
        }
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {

        if (hand == InteractionHand.MAIN_HAND) {
            interacted = !interacted;
        }

        return super.interactAt(player, vec, hand);
    }

}
