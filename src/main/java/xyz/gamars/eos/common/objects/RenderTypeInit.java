package xyz.gamars.eos.common.objects;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;

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


}
