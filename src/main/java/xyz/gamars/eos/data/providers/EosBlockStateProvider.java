package xyz.gamars.eos.data.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;

public class EosBlockStateProvider extends BlockStateProvider {


    public EosBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.MARBLE.get());
        simpleBlock(BlockInit.MARBLE_BRICKS.get());
        simpleBlock(BlockInit.CRACKED_MARBLE_BRICKS.get());
        axisBlock(BlockInit.MARBLE_PILLAR.get());

        ResourceLocation marbleBrick = modLoc("block/marble_bricks");
        stairsBlock(BlockInit.MARBLE_STAIRS.get(), marbleBrick);
        slabBlock(BlockInit.MARBLE_SLAB.get(), marbleBrick, marbleBrick);
        wallBlock(BlockInit.MARBLE_WALL.get(), marbleBrick);

    }
}
