package xyz.gamars.eos.common.objects.items.apollo;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import xyz.gamars.eos.Eos;

public class ApolloBowRenderer extends GeoItemRenderer<ApolloBowItem> {

    public ApolloBowRenderer() {
        super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "apollo_bow")));
    }
}
