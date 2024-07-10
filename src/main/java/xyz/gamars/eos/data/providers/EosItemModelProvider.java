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
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;

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

        wukongStaff(WukongsStaffItem.MAX_SIZE);

        spawnEggItem(ItemInit.STONE_EGG_SPAWN_EGG.get());
        spawnEggItem(ItemInit.MONKEY_SPAWN_EGG.get());

        blockItem(BlockInit.DEV_BLOCK.get());

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
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }


    public ItemModelBuilder blockItem(Block block) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "block/" + resourceLocation.getPath())));
    }

    public ItemModelBuilder wallBlockItem(Block block, Block parentBlock) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation parentBlockResourceLocation = BuiltInRegistries.BLOCK.getKey(parentBlock);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "block/" + parentBlockResourceLocation.getPath()));
    }

    public ItemModelBuilder spawnEggItem(Item item) {
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(item);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("minecraft:item/template_spawn_egg"));
    }

    public ItemModelBuilder wukongStaff(int maxSize) {
        ResourceLocation wukongStaffModLoc = BuiltInRegistries.ITEM.getKey(ItemInit.WUKONGS_STAFF.get());
        ItemModelBuilder wukongStaffItemModel = getBuilder(wukongStaffModLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("builtin/entity"));

        for (int i = 1; i <= maxSize; i++) {
            wukongStaffItemModel = wukongStaffItemModel.override()
                    .predicate(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "size"), i)
                    .model(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "item/wukongs_staff/wukongs_staff_" + i))).end();

        }
        return wukongStaffItemModel;
    }

    @Override
    public String getName() {
        return "Modeling for my babygirl ;)";
    }
}
