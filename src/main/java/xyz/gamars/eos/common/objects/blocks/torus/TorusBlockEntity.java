package xyz.gamars.eos.common.objects.blocks.torus;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class TorusBlockEntity extends BlockEntity {

    public TorusBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.TORUS_BLOCK_ENTITY.get(), pos, blockState);
    }
}
