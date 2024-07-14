package xyz.gamars.eos.common.objects.blocks.cone;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class ConeBlockEntity extends BlockEntity {

    public ConeBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.CONE_BLOCK_ENTITY.get(), pos, blockState);
    }
}
