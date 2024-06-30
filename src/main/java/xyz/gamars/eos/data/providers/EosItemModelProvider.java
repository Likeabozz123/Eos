package xyz.gamars.eos.data.providers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;
import xyz.gamars.eos.common.objects.ItemInit;

public class EosItemModelProvider extends ItemModelProvider {


    public EosItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(ItemInit.DEV_ITEM.get());
        handheldItem(ItemInit.POSEIDON_TRIDENT.get());
        handheldItem(ItemInit.TYRFINGER_SWORD.get());
        basicItem(ItemInit.PLUNGER.get());

        blockItem(BlockInit.RAW_MARBLE.get());
        blockItem(BlockInit.MARBLE_BRICKS.get());
        blockItem(BlockInit.LARGE_MARBLE_BRICKS.get());
        blockItem(BlockInit.CHISELED_MARBLE.get());
        blockItem(BlockInit.CHISELED_MARBLE_2.get());
        blockItem(BlockInit.CRACKED_MARBLE_BRICKS.get());
        blockItem(BlockInit.MARBLE_PILLAR.get());
        blockItem(BlockInit.MARBLE_STAIRS.get());
        blockItem(BlockInit.MARBLE_SLAB.get());
        wallBlockItem(BlockInit.MARBLE_WALL.get(), BlockInit.MARBLE_BRICKS.get());
    }

    public ItemModelBuilder handheldItem(Item item) {
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(item);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }


    public ItemModelBuilder blockItem(Block block) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(resourceLocation.getNamespace(), "block/" + resourceLocation.getPath())));
    }

    public ItemModelBuilder wallBlockItem(Block block, Block parentBlock) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation parentBlockResourceLocation = BuiltInRegistries.BLOCK.getKey(parentBlock);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("block/wall_inventory"))
                .texture("wall", new ResourceLocation(resourceLocation.getNamespace(), "block/" + parentBlockResourceLocation.getPath()));
    }

    @Override
    public String getName() {
        return "Modeling for my babygirl ;)";
    }
}
