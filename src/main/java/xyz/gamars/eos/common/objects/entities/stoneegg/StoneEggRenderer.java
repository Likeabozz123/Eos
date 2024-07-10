package xyz.gamars.eos.common.objects.entities.stoneegg;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import xyz.gamars.eos.Eos;

public class StoneEggRenderer extends GeoEntityRenderer<StoneEggEntity> {


    public StoneEggRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<StoneEggEntity>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "stone_egg")));
    }
}
