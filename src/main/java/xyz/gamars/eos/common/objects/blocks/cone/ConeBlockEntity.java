package xyz.gamars.eos.common.objects.blocks.cone;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class ConeBlockEntity extends BlockEntity {

    private float rotation = 0;
    private float duration = 5;
    private float elapsed = 0;

    public ConeBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.CONE_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, ConeBlockEntity blockEntity) {

        blockEntity.rotate();

    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, ConeBlockEntity blockEntity) {



    }

    public void rotate() {
        float time = elapsed / duration;
        rotation = Mth.PI * 10 * Mth.sin(time / 4);
        elapsed += Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
    }

    public float getRotation() {
        return rotation;
    }
}
