package xyz.gamars.eos.common.objects.blocks.cylinder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class CylinderBlockEntity extends BlockEntity {

    public CylinderBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.CYLINDER_BLOCK_ENTITY.get(), pos, blockState);
    }


}
