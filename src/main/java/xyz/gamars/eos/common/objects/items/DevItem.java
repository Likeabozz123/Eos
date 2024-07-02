package xyz.gamars.eos.common.objects.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.network.PacketDistributor;
import xyz.gamars.eos.common.objects.ParticleTypeInit;
import xyz.gamars.eos.network.payloads.TestPayload;

public class DevItem extends Item {

    public DevItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        if (level.isClientSide()) {
            PacketDistributor.sendToServer(new TestPayload("Hello from the client!"));
        } else {
            PacketDistributor.sendToPlayer((ServerPlayer) player, new TestPayload("Hello from the server!"));
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

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {

    }


}

