package xyz.gamars.eos.client.fx;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;

public class ParticleTypeInit {


    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Eos.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TEST_PARTICLE = PARTICLE_TYPES.register(
            "test_particle",
            () -> new SimpleParticleType(true)
    );

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

}
