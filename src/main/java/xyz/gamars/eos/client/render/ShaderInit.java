package xyz.gamars.eos.client.render;

import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.ShaderInstance;

public class ShaderInit {

    public static ShaderInstance testShader;
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_TEST_SHADER = new RenderStateShard.ShaderStateShard(() -> testShader);
    public static ShaderInstance brightSolid;
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_BRIGHT_SOLID = new RenderStateShard.ShaderStateShard(() -> brightSolid);

}
