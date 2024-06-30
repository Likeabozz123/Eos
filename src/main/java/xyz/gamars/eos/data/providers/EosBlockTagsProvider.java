package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;
import xyz.gamars.eos.common.objects.EnchantmentInit;

import java.util.concurrent.CompletableFuture;

public class EosBlockTagsProvider extends BlockTagsProvider {


    public EosBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.WALLS)
                .add(BlockInit.MARBLE_WALL.get());


    }
}
