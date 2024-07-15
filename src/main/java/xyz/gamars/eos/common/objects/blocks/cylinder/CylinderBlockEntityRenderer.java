package xyz.gamars.eos.common.objects.blocks.cylinder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import xyz.gamars.eos.client.render.RenderTypeInit;

public class CylinderBlockEntityRenderer implements BlockEntityRenderer<CylinderBlockEntity> {

    public CylinderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(CylinderBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        int sides = 36;
        int height = 36 ;
        int radius = 5;

        float startTheta = 0;
        float thetaStep = Mth.PI * 2 / sides;

        Matrix4f last = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderTypeInit.SOLID_TRIANGLES);
        poseStack.translate(0.5f, 0.001f, 0.5f);

        for (int i = 0; i < sides; ++i) {
            float theta1 = i * thetaStep + startTheta;
            float theta2 = i + 1 == sides ? Mth.PI * 2 : (i + 1) * thetaStep + startTheta;

            // cylinder
            Vector3f p0 = parametricCylinder(radius, theta1, height);
            Vector3f p1 = parametricCylinder(radius, theta1, 0);
            Vector3f p2 = parametricCylinder(radius, theta2, height);
            Vector3f p3 = parametricCylinder(radius, theta2, 0);

            vertexPosColor(vertexConsumer, last, p0, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p2, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p1, 0, 0, 0, 1);

            vertexPosColor(vertexConsumer, last, p3, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p1, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p2, 0, 0, 0, 1);

            // circle on top
            Vector3f pTopCenter = new Vector3f(0, height, 0);

            vertexPosColor(vertexConsumer, last, pTopCenter, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p0, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p2, 0, 0, 0, 1);

            // circle on bottom
            Vector3f pBottomCenter = new Vector3f(0, 0, 0);

            vertexPosColor(vertexConsumer, last, pBottomCenter, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p1, 0, 0, 0, 1);
            vertexPosColor(vertexConsumer, last, p3, 0, 0, 0, 1);
        }


    }

    public static Vector3f parametricCylinder(float radius, float theta, int height) {
        return new Vector3f(radius * Mth.cos(theta), height, radius * Mth.sin(theta));
    }

    public static void vertexPosColor(VertexConsumer vertexConsumer, Matrix4f last, Vector3f vector, float r, float g, float b, float a) {
        vertexConsumer.addVertex(last, vector.x(), vector.y(), vector.z())
                .setUv(0, 0)
                .setColor(r, g, b, a)
                .setLight(3);
    }


    @Override
    public AABB getRenderBoundingBox(CylinderBlockEntity blockEntity) {
        return AABB.INFINITE;
    }
}
