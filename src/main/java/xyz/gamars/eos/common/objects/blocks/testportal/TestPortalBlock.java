package xyz.gamars.eos.common.objects.blocks.testportal;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.common.objects.DimensionInit;


public class TestPortalBlock extends Block implements Portal {
    public TestPortalBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide()) {
            ResourceKey<Level> resourceKey = level.dimension() == DimensionInit.PLANET_NAMEK.getLevel() ? Level.OVERWORLD : DimensionInit.PLANET_NAMEK.getLevel();
            MinecraftServer minecraftServer = level.getServer();

            ServerLevel portalDimension = minecraftServer.getLevel(resourceKey);
            if (portalDimension != null && !entity.isPassenger()) {
                if (resourceKey == DimensionInit.PLANET_NAMEK.getLevel()) {
                    entity.changeDimension(new DimensionTransition(
                            portalDimension,
                            new Vec3(0,100,0),
                            entity.getDeltaMovement(),
                            entity.getYRot(),
                            entity.getXRot(),
                            DimensionTransition.PLAY_PORTAL_SOUND
                    ));
                }
            }
        }

    }

    @Nullable
    @Override
    public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        return null;
    }
}
