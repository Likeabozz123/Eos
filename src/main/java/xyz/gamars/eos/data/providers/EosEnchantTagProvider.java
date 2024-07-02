package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.EnchantmentInit;
import xyz.gamars.eos.common.objects.TagInit;

import java.util.concurrent.CompletableFuture;

public class EosEnchantTagProvider extends EnchantmentTagsProvider {
    public EosEnchantTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TagInit.POSEIDON_LUCK)
                .add(EnchantmentInit.POSEIDON_LUCK.get());


    }



}
