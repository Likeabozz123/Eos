package xyz.gamars.eos.client.listeners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockEntityTypeInit;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.blocks.cone.ConeBlockEntityRenderer;
import xyz.gamars.eos.common.objects.blocks.cylinder.CylinderBlockEntityRenderer;
import xyz.gamars.eos.common.objects.blocks.sphere.SphereBlockEntityRenderer;
import xyz.gamars.eos.common.objects.blocks.test.TestBlockEntityRenderer;
import xyz.gamars.eos.common.objects.blocks.torus.TorusBlockEntityRenderer;
import xyz.gamars.eos.common.objects.entities.monkey.MonkeyRenderer;
import xyz.gamars.eos.common.objects.entities.stoneegg.StoneEggRenderer;
import xyz.gamars.eos.common.objects.entities.wukongsstaff.WukongsStaffProjectileRenderer;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderersEventListener {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeInit.STONE_EGG.get(), StoneEggRenderer::new);
        event.registerEntityRenderer(EntityTypeInit.MONKEY.get(), MonkeyRenderer::new);
        event.registerEntityRenderer(EntityTypeInit.WUKONGS_STAFF_PROJECTILE.get(), WukongsStaffProjectileRenderer::new);

        event.registerBlockEntityRenderer(BlockEntityTypeInit.TEST_BLOCK_ENTITY.get(), TestBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.SPHERE_BLOCK_ENTITY.get(), SphereBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.CYLINDER_BLOCK_ENTITY.get(), CylinderBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.CONE_BLOCK_ENTITY.get(), ConeBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.TORUS_BLOCK_ENTITY.get(), TorusBlockEntityRenderer::new);
    }

}
