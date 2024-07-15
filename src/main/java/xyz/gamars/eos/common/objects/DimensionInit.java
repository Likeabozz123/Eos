package xyz.gamars.eos.common.objects;

import xyz.gamars.eos.common.objects.dimension.EosDimension;
import xyz.gamars.eos.common.objects.dimension.PlanetNamekDimension;

import java.util.ArrayList;
import java.util.function.Supplier;

public class DimensionInit {

    public static ArrayList<EosDimension> DIMENSIONS = new ArrayList<>();

    public static final EosDimension PLANET_NAMEK = createDimension(PlanetNamekDimension::new);


    private static EosDimension createDimension(Supplier<EosDimension> dimension) {
        DIMENSIONS.add(dimension.get());
        return dimension.get();
    }

}
