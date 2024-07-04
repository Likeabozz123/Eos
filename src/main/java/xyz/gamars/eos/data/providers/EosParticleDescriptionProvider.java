package xyz.gamars.eos.data.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import xyz.gamars.eos.common.objects.ParticleTypeInit;

import static xyz.gamars.eos.Eos.MOD_ID;

public class EosParticleDescriptionProvider extends ParticleDescriptionProvider {

    public EosParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        spriteSet(ParticleTypeInit.TEST_PARTICLE.get(),
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "test_particle"), 3, false);
    }
}
