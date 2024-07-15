package xyz.gamars.eos.common.objects;

import xyz.gamars.eos.common.objects.biomes.EosBiome;
import xyz.gamars.eos.common.objects.biomes.NamekBiome;

import java.util.ArrayList;
import java.util.function.Supplier;

public class BiomeInit {

    public static ArrayList<EosBiome> BIOMES = new ArrayList<>();

    public static final EosBiome NAMEK_BIOME = createBiome(NamekBiome::new);

    private static EosBiome createBiome(Supplier<EosBiome> biome) {
        BIOMES.add(biome.get());
        return biome.get();
    }
}
