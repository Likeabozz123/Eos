package xyz.gamars.eos;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Eos.MOD_ID)
public class Eos
{
    public static final String MOD_ID = "eos";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Eos(IEventBus modEventBus, ModContainer modContainer) {

    }

}
