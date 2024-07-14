package xyz.gamars.eos.common.objects.blocks.test;

import net.minecraft.client.Minecraft;
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

public class TestBlockEntity extends BlockEntity {

    private float radius = 1;
    private float duration = 5;
    private float elapsed = 0;

    public TestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityTypeInit.TEST_BLOCK_ENTITY.value(), pos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        tag.putFloat("Radius", this.radius);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        this.radius = tag.getFloat("Radius");
    }


    public static void clientTick(Level level, BlockPos pos, BlockState state, TestBlockEntity blockEntity) {

        blockEntity.growRadius();

    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TestBlockEntity blockEntity) {


        // level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);

    }

    public float getRadius() {
        return radius;
    }

    public void growRadius() {

        float time = elapsed / duration;
        // time /= 2;
        radius = Mth.abs(9 * Mth.sin(time)) + 1;
        elapsed += Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);

    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();

        tag.putFloat("Radius", this.radius);

        return tag;
    }

    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();

        tag.putFloat("Radius", this.radius);

        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
