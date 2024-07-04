package xyz.gamars.eos.client.listeners;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.ItemInit;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventListener {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(
                    ItemInit.WUKONGS_STAFF.get(),
                    ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "size"),
                    (stack, level, player, seed) -> {
                        return stack.get(DataComponentsInit.SIZE.value()).size();
                    }
            );

        });
    }

}
