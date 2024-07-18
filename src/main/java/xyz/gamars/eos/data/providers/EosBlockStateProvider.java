package xyz.gamars.eos.data.providers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;

import static net.neoforged.neoforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class EosBlockStateProvider extends BlockStateProvider {


    public EosBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(BlockInit.DEV_BLOCK.get());
        // simpleBlock(BlockInit.TEST_PORTAL_BLOCK.get());

        simpleBlock(BlockInit.RAW_MARBLE.get());
        simpleBlock(BlockInit.NAMEKIAN_ROCK.get());
        simpleBlock(BlockInit.AJISA_LEAVES.get());
        simpleBlock(BlockInit.MARBLE_BRICKS.get());
        simpleBlock(BlockInit.LARGE_MARBLE_BRICKS.get());
        simpleBlock(BlockInit.CHISELED_MARBLE.get());
        simpleBlock(BlockInit.CHISELED_MARBLE_2.get());
        simpleBlock(BlockInit.CRACKED_MARBLE_BRICKS.get());
        axisBlock(BlockInit.MARBLE_PILLAR.get());
        axisBlock(BlockInit.AJISA_LOG.get());
        simpleBlock(BlockInit.NAMEKIAN_GRASS_BLOCK.get(),cubeBottomTopTexture(BlockInit.NAMEKIAN_GRASS_BLOCK.get(),
                modLoc("block/namekian_grass_top"),
                modLoc("block/namekian_rock"),
                modLoc("block/namekian_grass_side")));


        ResourceLocation marbleBrick = modLoc("block/marble_bricks");
        stairsBlock(BlockInit.MARBLE_STAIRS.get(), marbleBrick);
        slabBlock(BlockInit.MARBLE_SLAB.get(), marbleBrick, marbleBrick);
        wallBlock(BlockInit.MARBLE_WALL.get(), marbleBrick);
    }
    public ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    public String name(Block block) {
        return key(block).getPath();
    }

    public BlockModelBuilder cubeBottomTopTexture(Block block, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {
        return models().withExistingParent(name(block), BLOCK_FOLDER + "/cube_bottom_top")
                .texture("top", top)
                .texture("bottom", bottom)
                .texture("side", side);
    }

    public BlockModelBuilder cubeBottomTopTexture(Block block) {
        return cubeBottomTopTexture(block,
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "block/" + name(block) + "_top"),
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "block/" + name(block) + "_bottom"),
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "block/" + name(block) + "_side"));
    }


}
