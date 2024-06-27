package xyz.gamars.eos.client.listeners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.client.fx.providers.TestParticleProvider;
import xyz.gamars.eos.common.objects.ParticleTypeInit;

@EventBusSubscriber(modid = Eos.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class RegisterParticleProvidersListener {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {

        event.registerSpriteSet(ParticleTypeInit.TEST_PARTICLE.get(), TestParticleProvider::new);
    }

}
