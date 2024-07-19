package xyz.gamars.eos.common.objects.entities.punchingbag;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import xyz.gamars.eos.Eos;

public class PunchingBagEntityRenderer extends GeoEntityRenderer<PunchingBagEntity> {

    public PunchingBagEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "punching_bag")));
    }
}
