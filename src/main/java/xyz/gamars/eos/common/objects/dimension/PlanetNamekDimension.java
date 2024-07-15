package xyz.gamars.eos.common.objects.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import xyz.gamars.eos.common.objects.BiomeInit;
import xyz.gamars.eos.common.objects.DimensionInit;

import java.util.OptionalLong;

public class PlanetNamekDimension extends EosDimension {

    public PlanetNamekDimension() {
        super("planet_namek");
    }

    @Override
    public void dimensionType(BootstrapContext<DimensionType> context) {
        context.register(DimensionInit.PLANET_NAMEK.getDimensionType(), new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    @Override
    public void levelStem(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(BiomeInit.NAMEK_BIOME.getBiomeKey())),
                noiseGeneratorSettings.getOrThrow(DimensionInit.PLANET_NAMEK.getNoiseGeneratorSettings())
        );
        LevelStem stem = new LevelStem(dimensionTypes.getOrThrow(DimensionInit.PLANET_NAMEK.getDimensionType()),wrappedChunkGenerator);
        context.register(DimensionInit.PLANET_NAMEK.getLevelStem(), stem);

    }
}
