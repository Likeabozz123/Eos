package xyz.gamars.eos.common.objects.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.entities.punchingbag.PunchingBagEntity;

import java.util.function.Consumer;

public class PunchingBagItem extends Item {

    public PunchingBagItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Direction direction = context.getClickedFace();
        if (direction == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else {
            Level level = context.getLevel();
            BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
            BlockPos blockpos = blockplacecontext.getClickedPos();
            ItemStack itemstack = context.getItemInHand();
            Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
            AABB aabb = EntityTypeInit.PUNCHING_BAG.get().getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if (level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()) {
                if (level instanceof ServerLevel serverlevel) {
                    Consumer<PunchingBagEntity> consumer = EntityType.createDefaultStackConfig(serverlevel, itemstack, context.getPlayer());
                    PunchingBagEntity punchingBag = EntityTypeInit.PUNCHING_BAG.get().create(serverlevel, consumer, blockpos, MobSpawnType.SPAWN_EGG, true, true);
                    if (punchingBag == null) {
                        return InteractionResult.FAIL;
                    }

                    serverlevel.addFreshEntityWithPassengers(punchingBag);
                    level.playSound(
                            null, punchingBag.getX(), punchingBag.getY(), punchingBag.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F
                    );
                    punchingBag.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                }

                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.FAIL;
            }
        }
    }
}
