package xyz.gamars.eos.common.objects.blocks.testblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ConduitBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class TestBlockEntity extends BlockEntity {

    public TestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.TEST_BLOCK_ENTITY.value(), pos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
    }


    public static void clientTick(Level level, BlockPos pos, BlockState state, TestBlockEntity blockEntity) {

    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TestBlockEntity blockEntity) {

    }

    public boolean shouldRenderFace(Direction face) {
        return face.getAxis() == Direction.Axis.X;
    }




}
