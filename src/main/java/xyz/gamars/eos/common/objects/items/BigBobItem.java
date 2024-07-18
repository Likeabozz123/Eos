package xyz.gamars.eos.common.objects.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.util.Lazy;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.utils.AttributeLocations;
import xyz.gamars.eos.utils.InventoryUtils;

import java.util.Properties;

public class BigBobItem extends Item {

    public BigBobItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 49.0, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.0F, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(AttributeLocations.ENTITY_INTERACTION_RANGE,
                                15,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.BLOCK_INTERACTION_RANGE  ,
                        new AttributeModifier(AttributeLocations.BLOCK_INTERACTION_RANGE,
                                15,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )

                .build();
    }

    public void onPlayerSwing(PlayerSwingEvent event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        if (event.getEntity() instanceof Player) {

        }
    }
}
