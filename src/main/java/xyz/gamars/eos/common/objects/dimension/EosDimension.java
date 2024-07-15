package xyz.gamars.eos.common.objects.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import xyz.gamars.eos.Eos;

public abstract class EosDimension {

    private String name;
    private ResourceKey<Level> level;
    private ResourceKey<LevelStem> levelStem;
    private ResourceKey<DimensionType> dimensionType;
    private ResourceKey<NoiseGeneratorSettings> noiseGeneratorSettings;


    public EosDimension(String name) {
        this.name = name;

        this.level = ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
        this.levelStem = ResourceKey.create(Registries.LEVEL_STEM,
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
        this.dimensionType = ResourceKey.create(Registries.DIMENSION_TYPE,
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name + "_dimension_type"));
        this.noiseGeneratorSettings = ResourceKey.create(Registries.NOISE_SETTINGS,
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name + "_noise_settings"));
    }

    public abstract void dimensionType(BootstrapContext<DimensionType> context);
    public abstract void levelStem(BootstrapContext<LevelStem> context);


    public ResourceKey<Level> getLevel() {
        return level;
    }

    public ResourceKey<LevelStem> getLevelStem() {
        return levelStem;
    }

    public ResourceKey<DimensionType> getDimensionType() {
        return dimensionType;
    }

    public ResourceKey<NoiseGeneratorSettings> getNoiseGeneratorSettings() {
        return noiseGeneratorSettings;
    }
}
