package xyz.gamars.eos.data;


import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.data.providers.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Eos.MOD_ID)
public class DataGenerators {


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new EosLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new EosItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new EosBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new EosEntityTypeTagProvider(packOutput, provider, existingFileHelper));
        generator.addProvider(event.includeClient(), new EosParticleDescriptionProvider(packOutput, existingFileHelper));
        EosBlockTagsProvider eosBlockTagsProvider = new EosBlockTagsProvider(packOutput, provider, existingFileHelper);
        generator.addProvider(event.includeServer(), eosBlockTagsProvider);
        generator.addProvider(event.includeServer(), new EosItemTagProvider(packOutput, provider, eosBlockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
                packOutput,
                provider,
                new RegistrySetBuilder()
                        .add(Registries.ENCHANTMENT, EosEnchantmentDataProvider::enchantments)
                        .add(Registries.BIOME, EosBiomeDataProvider::biomes)
                        .add(Registries.DIMENSION_TYPE, EosDimensionDataProvider::dimensionType)
                        .add(Registries.LEVEL_STEM, EosDimensionDataProvider::levelStem),
                Set.of(Eos.MOD_ID)

        ));

        generator.addProvider(event.includeServer(), new EosCuriosDataProvider(packOutput, existingFileHelper, provider));

    }





}
