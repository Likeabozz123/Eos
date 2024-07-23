package xyz.gamars.eos.common.objects.entities.hollowpurple;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import xyz.gamars.eos.client.render.RenderTypeInit;
import xyz.gamars.eos.utils.MathUtils;

public class HollowPurpleRenderer extends EntityRenderer<HollowPurpleEntity> {

    public HollowPurpleRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(HollowPurpleEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        int longs = 36;
        int lats = 36;
        float radius = entity.getRadiusData();
        int light = 3;


        Matrix4f last = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderTypeInit.SOLID_TRIANGLES);
        float startU = 0;
        float startV = 0;
        float endU = Mth.PI * 2;
        float endV = Mth.PI;
        float stepU = (endU - startU) / longs;
        float stepV = (endV - startV) / lats;
        for (int i = 0; i < longs; ++i) {
            // U-points
            for (int j = 0; j < lats; ++j) {
                // V-points
                float u1 = i * stepU + startU;
                float v1 = j * stepV + startV;
                float u2 = (i + 1 == longs) ? endU : (i + 1) * stepU + startU;
                float v2 = (j + 1 == lats) ? endV : (j + 1) * stepV + startV;
                Vector3f p0 = MathUtils.parametricSphere(u1, v1, radius);
                Vector3f p1 = MathUtils.parametricSphere(u1, v2, radius);
                Vector3f p2 = MathUtils.parametricSphere(u2, v1, radius);
                Vector3f p3 = MathUtils.parametricSphere(u2, v2, radius);

                float textureU1 = u1 / endU;
                float textureU2 = u2 / endU;
                float textureV1 = v1 / endV;
                float textureV2 = v2 / endV;
                vertexPosColorUVLight(vertexConsumer, last, p0.x(), p0.y(), p0.z(), 0, 0, 0, 1, textureU1, textureV1, light);
                vertexPosColorUVLight(vertexConsumer, last, p2.x(), p2.y(), p2.z(), 0, 0, 0, 1,  textureU2, textureV1, light);
                vertexPosColorUVLight(vertexConsumer, last, p1.x(), p1.y(), p1.z(), 0, 0, 0, 1,  textureU1, textureV2, light);


                vertexPosColorUVLight(vertexConsumer, last, p3.x(), p3.y(), p3.z(), 0, 0, 0, 1,  textureU2, textureV2, light);
                vertexPosColorUVLight(vertexConsumer, last, p1.x(), p1.y(), p1.z(), 0, 0, 0, 1,  textureU1, textureV2, light);
                vertexPosColorUVLight(vertexConsumer, last, p2.x(), p2.y(), p2.z(), 0, 0, 0, 1,  textureU2, textureV1, light);
            }
        }

    }

    public static void vertexPosColorUVLight(VertexConsumer vertexConsumer, Matrix4f last, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light) {
        vertexConsumer.addVertex(last, x, y, z)
                .setUv(u, v)
                .setColor(r, g, b, a)
                .setLight(light);
    }

    @Override
    public ResourceLocation getTextureLocation(HollowPurpleEntity entity) {
        return null;
    }
}
