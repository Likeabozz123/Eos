package xyz.gamars.eos.client.listeners;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.client.render.ShaderInit;

import java.io.IOException;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterShadersEventListener {

    @SubscribeEvent
    public static void onRegisterShaders(RegisterShadersEvent event) throws IOException {
        event.registerShader(
                new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "rendertype_test_shader"),
                        DefaultVertexFormat.POSITION_TEX),
                shaderInstance -> {
                    ShaderInit.testShader = shaderInstance;
                });

        event.registerShader(
                new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "rendertype_bright_solid"),
                        DefaultVertexFormat.NEW_ENTITY),
                shaderInstance -> {
                    ShaderInit.brightSolid = shaderInstance;
                });
    }


}
