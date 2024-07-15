package xyz.gamars.eos.common.objects.entities.wukongsstaff;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import xyz.gamars.eos.Eos;

public class WukongsStaffProjectileRenderer extends GeoEntityRenderer<WukongsStaffProjectileEntity> {

    public WukongsStaffProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "wukongs_staff")));
    }

    @Override
    public void render(WukongsStaffProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }


}
