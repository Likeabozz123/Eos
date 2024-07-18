package xyz.gamars.eos.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class EosLootTablesProvider extends LootTableProvider {
    public EosLootTablesProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(),
                List.of(new SubProviderEntry(EosBlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider);
    }

    private static final class EosBlockLootTables extends BlockLootSubProvider {
        private EosBlockLootTables(HolderLookup.Provider registries) {
            super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

        @Override
        protected void generate() {
            dropSelf(BlockInit.AJISA_LOG.get());
            dropSelf(BlockInit.NAMEKIAN_ROCK.get());
            add(BlockInit.NAMEKIAN_GRASS_BLOCK.get(),
               block -> createSingleItemTable(BlockInit.NAMEKIAN_ROCK.get()));
            dropSelf(BlockInit.DEV_BLOCK.get());
            dropSelf(BlockInit.MARBLE_BRICKS.get());
            dropSelf(BlockInit.MARBLE_WALL.get());
            dropSelf(BlockInit.MARBLE_STAIRS.get());
            dropSelf(BlockInit.MARBLE_PILLAR.get());
            dropSelf(BlockInit.MARBLE_SLAB.get());
            dropSelf(BlockInit.RAW_MARBLE.get());
            dropSelf(BlockInit.CHISELED_MARBLE.get());
            dropSelf(BlockInit.CHISELED_MARBLE_2.get());
            dropSelf(BlockInit.LARGE_MARBLE_BRICKS.get());
            dropSelf(BlockInit.CRACKED_MARBLE_BRICKS.get());
            add(BlockInit.CONE_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.CYLINDER_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.SPHERE_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.TEST_PORTAL_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.TEST_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.TORUS_BLOCK.get(),
               block -> createSingleItemTable(Blocks.AIR));
            add(BlockInit.AJISA_LEAVES.get(),
                    block -> createLeavesDrops(block,BlockInit.DEV_BLOCK.get(),NORMAL_LEAVES_SAPLING_CHANCES));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream().map(block -> (Block) block.get()).toList();
        }


    }

}
