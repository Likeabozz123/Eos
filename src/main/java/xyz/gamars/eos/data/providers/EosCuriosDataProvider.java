package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;
import xyz.gamars.eos.Eos;

import java.util.concurrent.CompletableFuture;

public class EosCuriosDataProvider extends CuriosDataProvider {


    public EosCuriosDataProvider(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
        super(Eos.MOD_ID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        createSlot("ear")
                .size(1)
                .addValidator(new ResourceLocation(Eos.MOD_ID, "ear_equippable"));

        createEntities("ear")
                .addSlots("ear")
                .addPlayer();


    }
}
