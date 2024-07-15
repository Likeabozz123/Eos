package xyz.gamars.eos.data.providers;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import xyz.gamars.eos.common.objects.DimensionInit;


public class EosDimensionDataProvider {
    public static void dimensionType(BootstrapContext<DimensionType> bootstrap) {

        DimensionInit.DIMENSIONS.forEach(dimension -> {
            dimension.dimensionType(bootstrap);
        });

    }

    public static void levelStem(BootstrapContext<LevelStem> bootstrap) {

        DimensionInit.DIMENSIONS.forEach(dimension -> {
            dimension.levelStem(bootstrap);
        });

    }


}
