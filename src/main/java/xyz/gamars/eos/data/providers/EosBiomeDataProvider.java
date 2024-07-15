package xyz.gamars.eos.data.providers;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import xyz.gamars.eos.common.objects.BiomeInit;

public class EosBiomeDataProvider {

    public static void biomes(BootstrapContext<Biome> context) {
        BiomeInit.BIOMES.forEach(biome -> {
            context.register(biome.getBiomeKey(), biome.defineBiome(context));
        });
    }


}
