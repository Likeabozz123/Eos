package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.DamageTypeInit;

import java.util.concurrent.CompletableFuture;

public class EosDamageTypeTagsProvider extends DamageTypeTagsProvider {

    public EosDamageTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Eos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(DamageTypeTags.BYPASSES_INVULNERABILITY)
                .add(DamageTypeInit.GOD_SLAYER);

    }


}
