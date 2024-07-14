package xyz.gamars.eos.common.objects.blocks.test;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class TestBlockEntity extends BlockEntity {

    public TestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.TEST_BLOCK_ENTITY.get(), pos, blockState);
    }
}
