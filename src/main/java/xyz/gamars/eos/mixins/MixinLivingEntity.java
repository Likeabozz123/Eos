package xyz.gamars.eos.mixins;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.gamars.eos.common.events.PlayerSwingEvent;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    @Shadow
    public int swingTime;

    public MixinLivingEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Z)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/LivingEntity;swingTime:I", opcode = Opcodes.PUTFIELD))
    public void swing(InteractionHand hand, boolean updateSelf, CallbackInfo ci) {
        if ((LivingEntity) (Object) this instanceof Player) {
            NeoForge.EVENT_BUS.post(new PlayerSwingEvent((Player) (Object) this, swingTime));
        }
    }





}
