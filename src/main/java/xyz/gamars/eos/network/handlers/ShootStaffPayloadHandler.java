package xyz.gamars.eos.network.handlers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.common.objects.entities.wukongsstaff.WukongsStaffProjectileEntity;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;
import xyz.gamars.eos.network.payloads.ShootStaffPayload;

public class ShootStaffPayloadHandler {

    public static class ServerPayloadHandler {

        public static void handleData(ShootStaffPayload payload, IPayloadContext context) {
            context.enqueueWork( () -> {
                Player player = context.player();
                float scale = payload.itemStack().get(DataComponentsInit.SIZE.get()).size() / (float) WukongsStaffItem.MAX_SIZE;

                WukongsStaffProjectileEntity wukongsStaffProjectile = new WukongsStaffProjectileEntity(player, player.level(), payload.itemStack().copyWithCount(1));
                wukongsStaffProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, payload.velocity(), payload.inaccuracy());
                player.level().addFreshEntity(wukongsStaffProjectile);

                wukongsStaffProjectile.getDimensions(Pose.STANDING).scale(10f);

                player.getMainHandItem().shrink(1);

            }).exceptionally(e -> {
                context.disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

}
