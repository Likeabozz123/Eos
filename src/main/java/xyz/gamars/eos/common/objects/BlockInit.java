package xyz.gamars.eos.common.objects;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Eos.MOD_ID);

    public static final DeferredHolder<Block, Block> RAW_MARBLE = create("raw_marble", () -> new Block(BlockBehaviour.Properties.of()));
    public static final DeferredHolder<Block, Block> MARBLE_BRICKS = create("marble_bricks", () -> new Block(BlockBehaviour.Properties.of()));
    public static final DeferredHolder<Block, Block> LARGE_MARBLE_BRICKS = create("large_marble_bricks", () -> new Block(BlockBehaviour.Properties.of()));
    public static final DeferredHolder<Block, Block> CRACKED_MARBLE_BRICKS = create("cracked_marble_bricks", () -> new Block(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, Block> CHISELED_MARBLE = create("chiseled_marble", () -> new Block(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, Block> CHISELED_MARBLE_2 = create("chiseled_marble_2", () -> new Block(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, RotatedPillarBlock> MARBLE_PILLAR = create("marble_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, StairBlock> MARBLE_STAIRS = create("marble_stairs", () -> new StairBlock(MARBLE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, SlabBlock> MARBLE_SLAB = create("marble_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get())));
    public static final DeferredHolder<Block, WallBlock> MARBLE_WALL = create("marble_wall", () -> new WallBlock(BlockBehaviour.Properties.of().ofLegacyCopy(MARBLE_BRICKS.get()).forceSolidOn()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <I extends Block> DeferredHolder<Block, I> create(String id, final Supplier<? extends I> blockSupplier, Item.Properties itemProperties) {
        DeferredHolder<Block, I> block = BLOCKS.register(id, blockSupplier);
        ItemInit.ITEMS.register(id, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }

    private static <I extends Block> DeferredHolder<Block, I> create(String id, final Supplier<? extends I> blockSupplier) {
        return create(id, blockSupplier, new Item.Properties());
    }

}
