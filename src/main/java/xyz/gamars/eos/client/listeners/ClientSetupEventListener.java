package xyz.gamars.eos.client.listeners;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.CuriosApi;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.ItemInit;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventListener {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> { // ItemProperties#register is not threadsafe, so we need to call it on the main thread
            ItemProperties.register(
                    // The item to apply the property to.
                    ItemInit.WUKONGS_STAFF.get(),
                    // The id of the property.
                    new ResourceLocation(Eos.MOD_ID, "size"),
                    // A reference to a method that calculates the override value.
                    // Parameters are the used item stack, the level context, the player using the item,
                    // and a random seed you can use.
                    (stack, level, player, seed) -> {
                        return stack.get(DataComponentsInit.SIZE.value()).size();
                    }
            );

            CuriosApi.registerCurioPredicate(
                    new ResourceLocation(Eos.MOD_ID, "ear_equippable"), (slotResult) -> {
                        if (slotResult.stack().getItem() instanceof WukongsStaffItem) {
                            return slotResult.stack().get(DataComponentsInit.SIZE.value()).size() == 1;
                        }
                        return false;
                    });


        });
    }

}
