package xyz.gamars.eos.objects.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import xyz.gamars.eos.Eos;

public class DevItem extends Item {

    public DevItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        if (!level.isClientSide()) {
            Eos.LOGGER.info("Used Dev Item!");

            player.hurt(level.damageSources().mobAttack(null), 2.0f);
            player.heal(4.0f);
        }

        return super.use(level, player, usedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (!context.getLevel().isClientSide()) {
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), Blocks.DIAMOND_BLOCK.defaultBlockState());
        }

        return super.useOn(context);
    }
}
