package xyz.gamars.eos.network.handlers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import xyz.gamars.eos.common.objects.entities.wukongsstaff.WukongsStaffProjectileEntity;
import xyz.gamars.eos.network.payloads.ShootStaffPayload;
import xyz.gamars.eos.utils.InventoryUtils;

public class SpawnEntityPayloadHandler {

    public static class ServerPayloadHandler {

        public static void handleData(ShootStaffPayload payload, IPayloadContext context) {
            context.enqueueWork( () -> {
                Player player = context.player();
                WukongsStaffProjectileEntity wukongsStaffProjectile = new WukongsStaffProjectileEntity(player, player.level(), payload.itemStack());
                wukongsStaffProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, payload.velocity(), payload.inaccuracy());
                player.getMainHandItem().shrink(1);
                player.level().addFreshEntity(wukongsStaffProjectile);

            }).exceptionally(e -> {
                context.disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

}
