package xyz.gamars.eos.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.IKeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class KeyMappingInit {

    public static final ArrayList<Lazy<KeyMapping>> KEY_MAPPINGS = new ArrayList<>();

    public static final Lazy<KeyMapping> WHIP_OUT_STAFF = create(
            "key.eos.whip_out_staff",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            "key.categories.eos");

    public static final Lazy<KeyMapping> SHOOT_STAFF = create(
            "key.eos.shoot_staff",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.eos"
    );

    public static Lazy<KeyMapping> create(String description, IKeyConflictContext keyConflictContext, final InputConstants.Type inputType, final int keyCode, String category) {
        Lazy<KeyMapping> keyMapping =
                Lazy.of(() ->  new KeyMapping(
                        description,
                        keyConflictContext,
                        inputType,
                        keyCode,
                        category));
        KEY_MAPPINGS.add(keyMapping);
        return keyMapping;
    }

}
