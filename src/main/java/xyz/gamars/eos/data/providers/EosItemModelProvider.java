package xyz.gamars.eos.data.providers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.ItemInit;

public class EosItemModelProvider extends ItemModelProvider {


    public EosItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(ItemInit.DEV_ITEM.get());
        basicItem(ItemInit.PLUNGER.get());

    }

    public ItemModelBuilder handheldItem(Item item) {
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(item);
        return getBuilder(resourceLocation.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }

    @Override
    public String getName() {
        return "Modeling for my babygirl ;)";
    }
}
