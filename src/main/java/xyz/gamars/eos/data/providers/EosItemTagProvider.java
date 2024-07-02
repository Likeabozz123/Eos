package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.ItemInit;
import xyz.gamars.eos.common.objects.TagInit;

import java.util.concurrent.CompletableFuture;

public class EosItemTagProvider extends ItemTagsProvider {


    public EosItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(TagInit.POSEIDON_HELMET)
                .add(ItemInit.POSEIDON_HELMET.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ItemInit.POSEIDON_CHESTPLATE.get());



    }
}
