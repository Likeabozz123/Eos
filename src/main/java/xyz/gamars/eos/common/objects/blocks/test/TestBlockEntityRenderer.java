package xyz.gamars.eos.common.objects.blocks.test;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.RenderTypeInit;
import xyz.gamars.eos.common.objects.blocks.sphere.SphereBlockEntity;

public class TestBlockEntityRenderer implements BlockEntityRenderer<TestBlockEntity> {

    public TestBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(TestBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        Matrix4f last = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderTypeInit.SOLID_TRIANGLES);
        poseStack.translate(0.5f, 0, 0.5f);


        Vector3f p0 = new Vector3f(0.5f, 0.5f, 0.5f);
        Vector3f p1 = new Vector3f(-0.5f, 0.5f, 0.5f);
        Vector3f p2 = new Vector3f(0.5f, 0.5f, -0.5f);
        Vector3f p3 = new Vector3f(-0.5f, 0.5f, -0.5f);

        vertexPosColor(vertexConsumer, last, p0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p1, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p3, 1, 1, 1, 1);

        vertexPosColor(vertexConsumer, last, p0, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p2, 1, 1, 1, 1);
        vertexPosColor(vertexConsumer, last, p3, 1, 1, 1, 1);



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
