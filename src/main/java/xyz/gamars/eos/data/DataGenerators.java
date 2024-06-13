package xyz.gamars.eos.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.data.providers.EosItemModelProvider;
import xyz.gamars.eos.data.providers.EosLanguageProvider;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Eos.MOD_ID)
public class DataGenerators {


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new EosLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new EosItemModelProvider(packOutput, existingFileHelper));
    }


}
