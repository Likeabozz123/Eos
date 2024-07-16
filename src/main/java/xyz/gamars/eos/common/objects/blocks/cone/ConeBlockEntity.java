package xyz.gamars.eos.common.objects.blocks.cone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;

public class ConeBlockEntity extends BlockEntity {

    private float rotation = 0;
    private float duration = 5;
    private float serverElapsed = 0;

    public ConeBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.CONE_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, ConeBlockEntity blockEntity) {



    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, ConeBlockEntity blockEntity) {

        blockEntity.rotate();
        level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);

    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        this.rotation = tag.getFloat("Rotation");


    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        tag.putFloat("Rotation", this.rotation);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();

        tag.putFloat("Rotation", this.rotation);

        return tag;
    }

    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();

        tag.putFloat("Rotation", this.rotation);

        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void rotate() {
        float time = serverElapsed / duration;
        rotation = Mth.PI * 2 * Mth.sin(time / 8);
        serverElapsed++;
    }

}
