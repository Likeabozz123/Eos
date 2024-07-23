package xyz.gamars.eos.common.objects.items;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
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
import xyz.gamars.eos.common.objects.entities.hollowpurple.HollowPurpleEntity;
import xyz.gamars.eos.common.objects.entities.hollowpurple.HollowPurpleRenderer;
import xyz.gamars.eos.common.objects.entities.wukongsstaff.WukongsStaffProjectileEntity;

public class DevItem extends Item {

    public DevItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        if (!level.isClientSide()) {
            HollowPurpleEntity hollowPurpleEntity = new HollowPurpleEntity(level, player.getX(), player.getEyeY(), player.getZ());
            hollowPurpleEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 0.5f, 0f);
            level.addFreshEntity(hollowPurpleEntity);
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

