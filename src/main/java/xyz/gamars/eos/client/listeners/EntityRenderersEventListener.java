package xyz.gamars.eos.client.listeners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.common.objects.entities.monkey.MonkeyRenderer;
import xyz.gamars.eos.common.objects.entities.stoneegg.StoneEggRenderer;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderersEventListener {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeInit.STONE_EGG.get(), StoneEggRenderer::new);
        event.registerEntityRenderer(EntityTypeInit.MONKEY.get(), MonkeyRenderer::new);
    }

}
