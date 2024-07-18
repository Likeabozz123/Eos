package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import xyz.gamars.eos.Eos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class DamageTypeInit {

    public static final HashMap<ResourceKey<DamageType>, DamageType> DAMAGE_TYPES = new HashMap<>();

    public static final ResourceKey<DamageType> GOD_SLAYER = create("god_slayer");

    private static ResourceKey<DamageType> create(String name) {
        ResourceKey<DamageType> damageType = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, name));
        DAMAGE_TYPES.put(damageType, new DamageType(name, 0.0F));
        return damageType;
    }

}
