package xyz.gamars.eos.common.objects.entities.monkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import xyz.gamars.eos.Eos;

public class MonkeyRenderer extends GeoEntityRenderer<MonkeyEntity> {


    public MonkeyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<MonkeyEntity>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "monkey")));
    }
}
