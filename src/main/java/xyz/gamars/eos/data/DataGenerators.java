package xyz.gamars.eos.data;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.data.providers.EosEntityTypeTagProvider;
import xyz.gamars.eos.data.providers.EosItemModelProvider;
import xyz.gamars.eos.data.providers.EosLanguageProvider;

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
        generator.addProvider(event.includeServer(), new EosEntityTypeTagProvider(packOutput, provider, existingFileHelper));
    }





}
