package xyz.gamars.eos;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.slf4j.Logger;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.common.objects.*;
import xyz.gamars.eos.common.objects.items.coolassstick.CoolAssStickItem;

@Mod(Eos.MOD_ID)
public class Eos
{
    public static final String MOD_ID = "eos";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Eos(IEventBus eventBus, ModContainer modContainer) {
        ItemInit.register(eventBus);
        BlockInit.register(eventBus);
        BlockEntityTypeInit.register(eventBus);
        ArmorMaterialsInit.register(eventBus);
        EnchantmentInit.register(eventBus);
        CreativeTabInit.register(eventBus);
        ParticleTypeInit.register(eventBus);

        registerEvents();
    }

    private static void registerEvents() {

    }





}
