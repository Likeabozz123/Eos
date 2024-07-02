package xyz.gamars.eos.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class KeyMappingInit {

    public static final Lazy<KeyMapping> WHIP_OUT_STAFF = Lazy.of(() ->
            new KeyMapping(
                    "key.eos.whip_out_staff",
                    KeyConflictContext.IN_GAME,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_V,
                    "key.categories.eos"
            ));


}
