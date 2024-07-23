package xyz.gamars.eos.common.objects.blocks.torus;

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
import xyz.gamars.eos.utils.MathUtils;

public class TorusBlockEntityRenderer implements BlockEntityRenderer<TorusBlockEntity> {

    public TorusBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(TorusBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        int sides = 36;
        int majorRadius = 3;
        int minorRadius = 1;

        float startTheta = 0;
        float startPhi = 0;
        float thetaStep = Mth.PI * 2 / 36;
        float phiStep = Mth.PI * 2 / 36;

        Matrix4f last = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderTypeInit.SOLID_TRIANGLES);
        poseStack.translate(0.5f, 0, 0.5f);

        for (int i = 0; i < sides; ++i) {
            for (int j = 0; j < sides; ++j) {

                float theta1 = i * thetaStep;
                float theta2 = i + 1 == sides ? Mth.PI * 2 + startTheta : (i + 1) * thetaStep + startTheta;
                float phi1 = j * thetaStep;
                float phi2 = j + 1 == sides ? Mth.PI * 2 + startPhi : (j + 1) * phiStep + startPhi;

                Vector3f p0 = MathUtils.parametricTorus(majorRadius, minorRadius, theta1, phi1);
                Vector3f p1 = MathUtils.parametricTorus(majorRadius, minorRadius, theta2, phi1);
                Vector3f p2 = MathUtils.parametricTorus(majorRadius, minorRadius, theta1, phi2);
                Vector3f p3 = MathUtils.parametricTorus(majorRadius, minorRadius, theta2, phi2);

                vertexPosColor(vertexConsumer, last, p0, 0, 0, 0, 1);
                vertexPosColor(vertexConsumer, last, p1, 0, 0, 0, 1);
                vertexPosColor(vertexConsumer, last, p3, 0, 0, 0, 1);

                vertexPosColor(vertexConsumer, last, p3, 0, 0, 0, 1);
                vertexPosColor(vertexConsumer, last, p2, 0, 0, 0, 1);
                vertexPosColor(vertexConsumer, last, p0, 0, 0, 0, 1);

            }
        }




    }



    public static void vertexPosColor(VertexConsumer vertexConsumer, Matrix4f last, Vector3f vector, float r, float g, float b, float a) {
        vertexConsumer.addVertex(last, vector.x(), vector.y(), vector.z())
                .setUv(0, 0)
                .setColor(r, g, b, a)
                .setLight(3);
    }

    @Override
    public AABB getRenderBoundingBox(TorusBlockEntity blockEntity) {
        return AABB.INFINITE;
    }
}
