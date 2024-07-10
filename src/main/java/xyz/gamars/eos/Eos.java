package xyz.gamars.eos;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import xyz.gamars.eos.common.objects.*;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;

@Mod(Eos.MOD_ID)
public class Eos
{
    public static final String MOD_ID = "eos";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Eos(IEventBus eventBus, ModContainer modContainer) {
        ItemInit.register(eventBus);
        BlockInit.register(eventBus);
        BlockEntityTypeInit.register(eventBus);
        EntityTypeInit.register(eventBus);
        ArmorMaterialsInit.register(eventBus);
        CreativeTabInit.register(eventBus);
        ParticleTypeInit.register(eventBus);
        DataComponentsInit.register(eventBus);

        eventBus.addListener(this::onCommonSetup);
    }


    public static void registerCurioPredicates() {
        CuriosApi.registerCurioPredicate(
                ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "ear_equippable"), (slotResult) -> {
                    if (slotResult.stack().getItem() instanceof WukongsStaffItem) {
                        return slotResult.stack().get(DataComponentsInit.SIZE.value()).size() == 1;
                    }
                    return false;
                });
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        registerCurioPredicates();
    }


}
