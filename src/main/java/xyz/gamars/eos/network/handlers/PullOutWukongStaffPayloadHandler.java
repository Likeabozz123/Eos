package xyz.gamars.eos.network.handlers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import top.theillusivec4.curios.api.CuriosApi;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;
import xyz.gamars.eos.network.payloads.PullOutWukongStaffPayload;

public class PullOutWukongStaffPayloadHandler {

    public static class ServerPayloadHandler {
        public static void handleData(PullOutWukongStaffPayload payload, IPayloadContext context) {
            context.enqueueWork(() -> {
                payload.itemStack().update(DataComponentsInit.SIZE.value(), new SizeComponent(1, WukongsStaffItem.MAX_SIZE), s -> {
                    return new SizeComponent(5 , WukongsStaffItem.MAX_SIZE);
                });
                ((WukongsStaffItem) payload.itemStack().getItem()).updateItem(payload.itemStack());
                context.player().getInventory().add(payload.itemStack());

                CuriosApi.getCuriosInventory(context.player()).ifPresent( curiosInventory -> {
                    curiosInventory.setEquippedCurio(payload.identifier(), payload.index(), ItemStack.EMPTY);
                } );
            }).exceptionally(e -> {
                context.disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

}
