package xyz.gamars.eos.common.objects.blocks.test;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import xyz.gamars.eos.client.render.RenderTypeInit;

public class TestBlockEntityRenderer implements BlockEntityRenderer<TestBlockEntity> {

    public TestBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(TestBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        Matrix4f last = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderTypeInit.TEST_RENDER);
        poseStack.translate(0.5f, 0, 0.5f);


        // flat square
        Vector3f p0 = new Vector3f(0.5f,  1.0f, 0.5f);
        Vector3f p1 = new Vector3f(-0.5f, 1.0f, 0.5f);
        Vector3f p2 = new Vector3f(0.5f,  1.0f, -0.5f);
        Vector3f p3 = new Vector3f(-0.5f, 1.0f, -0.5f);

        vertexPosColor(vertexConsumer, last, p0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p1, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p3, 1, 1, 1, 1);

        vertexPosColor(vertexConsumer, last, p0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p2, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p3, 1, 1, 1, 1);

        // upright square

        /*
        Vector3f s0 = new Vector3f(0.5f, 1f, 0);
        Vector3f s1 = new Vector3f(-0.5f, 1f, 0);
        Vector3f s2 = new Vector3f(0.5f, 0f, 0);
        Vector3f s3 = new Vector3f(-0.5f, 0, 0);

        vertexPosColor(vertexConsumer, last, s0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, s1, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, s3, 1, 1, 1, 1);

        vertexPosColor(vertexConsumer, last, s0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, s2, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, s3, 1, 1, 1, 1);
        */



    }

    public static void vertexPosColor(VertexConsumer vertexConsumer, Matrix4f last, Vector3f vector, float r, float g, float b, float a) {
        vertexConsumer.addVertex(last, vector.x(), vector.y(), vector.z())
                .setUv(0, 0)
                .setColor(r, g, b, a)
                .setLight(3);
    }

    @Override
    public AABB getRenderBoundingBox(TestBlockEntity blockEntity) {
        return AABB.INFINITE;
    }
}
