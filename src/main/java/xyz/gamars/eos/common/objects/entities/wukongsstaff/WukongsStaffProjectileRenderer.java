package xyz.gamars.eos.common.objects.entities.wukongsstaff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;

public class WukongsStaffProjectileRenderer extends GeoEntityRenderer<WukongsStaffProjectileEntity> {

    public WukongsStaffProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "wukongs_staff")));

    }

    @Override
    public void render(WukongsStaffProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {


        float scale = entity.getSize() * 0.1f;
        poseStack.scale(scale, scale, scale);

        poseStack.rotateAround(Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getYRot()) - 90.0F), 0, 0, 0);
        poseStack.rotateAround(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.getXRot()) + 90.0F), 0, 0, 0);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);


    }


}
