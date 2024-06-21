package xyz.gamars.eos;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import xyz.gamars.eos.objects.CreativeTabInit;
import xyz.gamars.eos.objects.EnchantmentInit;
import xyz.gamars.eos.objects.ItemInit;

@Mod(Eos.MOD_ID)
public class Eos
{
    public static final String MOD_ID = "eos";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Eos(IEventBus eventBus, ModContainer modContainer) {
        ItemInit.register(eventBus);
        EnchantmentInit.register(eventBus);
        CreativeTabInit.register(eventBus);
    }



}
