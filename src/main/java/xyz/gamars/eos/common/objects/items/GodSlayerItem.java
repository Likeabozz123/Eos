package xyz.gamars.eos.common.objects.items;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import xyz.gamars.eos.common.objects.DamageTypeInit;
import xyz.gamars.eos.common.objects.ItemInit;

public class GodSlayerItem extends Item {

    public GodSlayerItem(Properties properties) {
        super(properties);
    }

    public void onPlayerAttack(AttackEntityEvent event) {
        Player attacker = event.getEntity();

        if (attacker.getMainHandItem().is(ItemInit.GOD_SLAYER.get())) {
            if (!attacker.level().isClientSide()) {
                if (event.getTarget() instanceof Player) {
                    Player target = (Player) event.getTarget();
                    ServerLevel serverLevel = (ServerLevel) attacker.level();
                    RegistryAccess registryAccess = serverLevel.registryAccess();
                    Registry<DamageType> damageTypeRegistry = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);
                    target.hurt(new DamageSource(damageTypeRegistry.getHolderOrThrow(DamageTypeInit.GOD_SLAYER)), 10.0f);
                }
            }
        }

    }



}
