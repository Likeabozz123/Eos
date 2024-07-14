package xyz.gamars.eos.common.objects;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;
import net.minecraft.resources.ResourceLocation;
import xyz.gamars.eos.Eos;

public class RenderTypeInit {

    public static final RenderType END_PORTAL_TRIANGLES = RenderType.create(
            "end_portal_triangles",
            DefaultVertexFormat.POSITION,
            VertexFormat.Mode.TRIANGLES,
            1536,
            false,
            false,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_END_PORTAL_SHADER)
                    .setTextureState(
                            RenderStateShard.MultiTextureStateShard.builder()
                                    .add(TheEndPortalRenderer.END_SKY_LOCATION, false, false)
                                    .add(TheEndPortalRenderer.END_PORTAL_LOCATION, false, false)
                                    .build()
                    )
                    .setCullState(RenderStateShard.NO_CULL)
                    .createCompositeState(false)
    );

    public static final RenderType SOLID_TRIANGLES = RenderType.create(
            "solid_triangles",
            DefaultVertexFormat.POSITION,
            VertexFormat.Mode.TRIANGLES,
            1536,
            false,
            false,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_SOLID_SHADER)
                    .setCullState(RenderStateShard.NO_CULL)
                    .createCompositeState(false)
    );

    public static final RenderType LINES_TRIANGLES = RenderType.create(
            "lines_triangles",
            DefaultVertexFormat.POSITION,
            VertexFormat.Mode.TRIANGLES,
            1536,
            false,
            false,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_OUTLINE_SHADER)
                    .setCullState(RenderStateShard.NO_CULL)
                    .setOutputState(RenderType.OUTLINE_TARGET)
                    .createCompositeState(false)
    );

    public static final RenderType TEXTURE_TRIANGLES = RenderType.create(
            "texture_triangles",
            DefaultVertexFormat.POSITION_TEX,
            VertexFormat.Mode.TRIANGLES,
            1536,
            false,
            false,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.POSITION_TEX_SHADER)
                    .setTextureState(
                            new RenderStateShard.TextureStateShard(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "textures/entity/test_texture.png"), false, false)
                    )
                    .setCullState(RenderStateShard.NO_CULL)
                    .createCompositeState(false)
    );


}
