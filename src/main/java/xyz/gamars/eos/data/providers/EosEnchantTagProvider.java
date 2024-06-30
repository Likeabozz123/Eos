package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.EnchantmentInit;
import xyz.gamars.eos.common.objects.TagInit;

import java.util.Collection;
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
