package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.blocks.cone.ConeBlockEntity;
import xyz.gamars.eos.common.objects.blocks.cylinder.CylinderBlockEntity;
import xyz.gamars.eos.common.objects.blocks.sphere.SphereBlockEntity;
import xyz.gamars.eos.common.objects.blocks.test.TestBlockEntity;
import xyz.gamars.eos.common.objects.blocks.torus.TorusBlockEntity;

public class BlockEntityTypeInit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Eos.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TestBlockEntity>> TEST_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("test_block_entity",
            () -> BlockEntityType.Builder.of(TestBlockEntity::new, BlockInit.TEST_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SphereBlockEntity>> SPHERE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("sphere_block_entity",
            () -> BlockEntityType.Builder.of(SphereBlockEntity::new, BlockInit.SPHERE_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CylinderBlockEntity>> CYLINDER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("cylinder_block_entity",
            () -> BlockEntityType.Builder.of(CylinderBlockEntity::new, BlockInit.CYLINDER_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConeBlockEntity>> CONE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("cone_block_entity",
            () -> BlockEntityType.Builder.of(ConeBlockEntity::new, BlockInit.CONE_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TorusBlockEntity>> TORUS_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("torus_block_entity",
            () -> BlockEntityType.Builder.of(TorusBlockEntity::new, BlockInit.TORUS_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }

}
