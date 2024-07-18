package xyz.gamars.eos.common.objects.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.util.Lazy;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
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
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.utils.AttributeLocations;
import xyz.gamars.eos.utils.InventoryUtils;

import java.util.List;
import java.util.Properties;

public class BigBobItem extends Item {

    private boolean swinging = false;
    private boolean holdingItem = false;
    private int currentSwingRound = 0;
    private int swingRoundCount = 2;
    private List<Mob> nearbyMobs;


    public BigBobItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 29.0, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.4F, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_KNOCKBACK,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(AttributeLocations.ENTITY_INTERACTION_RANGE,
                                15,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
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
        if (!level.isClientSide()) {
            if (player.isCrouching()) {
                AABB hitbox = new AABB(player.blockPosition());
                hitbox = hitbox.inflate(15, 3, 15);
                nearbyMobs = player.level().getEntitiesOfClass(Mob.class, hitbox);
                swinging = true;
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity) {
            holdingItem = ((LivingEntity) entity).getMainHandItem() == stack;
        }
    }

    public void onServerTick(ServerTickEvent.Post event) {

        if (!holdingItem) {
            swinging = false;
            currentSwingRound = 0;
        }

        if (swinging && holdingItem) {
            float currentTick = event.getServer().getTickCount();

            if (currentTick % 10 == 0) {
                for(Mob mob : nearbyMobs) {
                    DamageSource damageSource = new DamageSource(event.getServer().registryAccess().holderOrThrow(DamageTypes.PLAYER_ATTACK));
                    mob.hurt(damageSource,10);
                }
                currentSwingRound++;
                if (currentSwingRound >= swingRoundCount) {
                    swinging = false;
                    currentSwingRound = 0;
                }
            }
        }

    }
}
