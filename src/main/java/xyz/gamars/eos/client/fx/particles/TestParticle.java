package xyz.gamars.eos.client.fx.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class TestParticle extends TextureSheetParticle {

    private final SpriteSet spriteSet;

    public TestParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet) {
        super(pLevel, pX, pY, pZ);
        this.lifetime = 40;
        this.gravity = -0.4f;
        this.spriteSet = spriteSet;

        setSpriteFromAge(spriteSet);


    }


    @Override
    public void tick() {

        setSpriteFromAge(spriteSet);

        super.tick();
    }

    @Override
    public void render(VertexConsumer pBuffer, Camera pRenderInfo, float pPartialTicks) {
        super.render(pBuffer, pRenderInfo, pPartialTicks);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }



}
