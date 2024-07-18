package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.entities.monkey.MonkeyEntity;
import xyz.gamars.eos.common.objects.entities.stoneegg.StoneEggEntity;
import xyz.gamars.eos.common.objects.entities.wukongsstaff.WukongsStaffProjectileEntity;

public class EntityTypeInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Eos.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<StoneEggEntity>> STONE_EGG = register("stone_egg",
            EntityType.Builder.<StoneEggEntity>of(StoneEggEntity::new, MobCategory.MISC)
                    .sized(0.6f, 0.75f)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<MonkeyEntity>> MONKEY = register("monkey",
            EntityType.Builder.<MonkeyEntity>of(MonkeyEntity::new, MobCategory.MISC)
                    .sized(0.6f, 1.5f)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<WukongsStaffProjectileEntity>> WUKONGS_STAFF_PROJECTILE = register("wukongs_staff",
            EntityType.Builder.<WukongsStaffProjectileEntity>of(WukongsStaffProjectileEntity::new, MobCategory.MISC)
                    .sized(0.3f, 1.9f)
    );

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String key, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(key, () -> builder.build(key));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
