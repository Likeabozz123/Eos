package xyz.gamars.eos.common.objects.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.ParticleTypeInit;

public class DevBlock extends Block {

    public DevBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {

        if (!level.isClientSide()) {

            if (entity.isSprinting()) {

                level.explode(entity, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 10f, Level.ExplosionInteraction.TRIGGER);
            }

        }


        super.stepOn(level, blockPos, blockState, entity);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {

        level.addParticle(ParticleTypeInit.TEST_PARTICLE.get(), blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5, 0, 3, 0);

        super.animateTick(blockState, level, blockPos, randomSource);
    }


}
