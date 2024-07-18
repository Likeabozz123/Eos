package xyz.gamars.eos.common.objects.items;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.utils.InventoryUtils;

import java.util.Random;

public class TyrfingrSwordItem extends SwordItem {
    public TyrfingrSwordItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    public void onPlayerSwing(PlayerSwingEvent event) {

        if (!event.getLevel().isClientSide()) {
            if (event.getEntity() instanceof Player) {

                Player player = event.getEntity();
                if (event.getItemSwung().is(this)) {
                    Random rand = new Random();
                    double x = rand.nextDouble(0, 1.0);
                    if (x <= 0.7) {
                        InventoryUtils.modifyItemAttribute(
                                player.getMainHandItem(),
                                Attributes.ATTACK_DAMAGE,
                                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 5.0f, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        );
                        InventoryUtils.modifyItemAttribute(
                                player.getMainHandItem(),
                                Attributes.ATTACK_SPEED,
                                new AttributeModifier(BASE_ATTACK_SPEED_ID, 10, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        );
                    } else {
                        InventoryUtils.modifyItemAttribute(
                                player.getMainHandItem(),
                                Attributes.ATTACK_DAMAGE,
                                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 50f, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        );
                        InventoryUtils.modifyItemAttribute(
                                player.getMainHandItem(),
                                Attributes.ATTACK_SPEED,
                                new AttributeModifier(BASE_ATTACK_SPEED_ID, -10, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        );
                    }
                }
            }
        }

    }

}
