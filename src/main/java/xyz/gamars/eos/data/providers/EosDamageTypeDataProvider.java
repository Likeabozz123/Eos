package xyz.gamars.eos.data.providers;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;
import xyz.gamars.eos.common.objects.DamageTypeInit;

public class EosDamageTypeDataProvider {

    public static void damageType(BootstrapContext<DamageType> context) {
        DamageTypeInit.DAMAGE_TYPES.forEach(context::register);
    }

}
