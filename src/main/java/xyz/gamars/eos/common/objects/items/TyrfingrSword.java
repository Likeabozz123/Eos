package xyz.gamars.eos.common.objects.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import xyz.gamars.eos.common.events.PlayerSwingEvent;

import java.util.Random;

public class TyrfingrSword extends SwordItem {
    public TyrfingrSword(Tier pTier, Properties pProperties) {
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
                        player.getMainHandItem().set(DataComponents.ATTRIBUTE_MODIFIERS,
                                ItemAttributeModifiers.builder()
                                        .add(
                                                Attributes.ATTACK_DAMAGE,
                                                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 5.0f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .add(
                                                Attributes.ATTACK_SPEED,
                                                new AttributeModifier(BASE_ATTACK_SPEED_ID, 10, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .build());
                    } else {
                        player.getMainHandItem().set(DataComponents.ATTRIBUTE_MODIFIERS,
                                ItemAttributeModifiers.builder()
                                        .add(
                                                Attributes.ATTACK_DAMAGE,
                                                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 50.0f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .add(
                                                Attributes.ATTACK_SPEED,
                                                new AttributeModifier(BASE_ATTACK_SPEED_ID, -10f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .build());
                    }
                }
            }
        }

    }

}
