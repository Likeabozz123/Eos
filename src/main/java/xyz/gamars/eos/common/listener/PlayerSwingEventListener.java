package xyz.gamars.eos.common.listener;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.events.PlayerSwingEvent;
import xyz.gamars.eos.common.objects.ItemInit;

import java.util.ArrayList;
import java.util.Random;


@EventBusSubscriber(modid = Eos.MOD_ID)
public class PlayerSwingEventListener {


    @SubscribeEvent
    public static void onPlayerSwing(PlayerSwingEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.PLUNGER)) {
                    player.level().explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
                }

                if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.COOL_ASS_STICK)) {

                    player.level()
                            .playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, player.getSoundSource(), 1.0F, 1.0F);

                    double d0 = -Mth.sin(player.getYRot() * (float) (Math.PI / 180.0)) * 3;
                    double d1 = Mth.cos(player.getYRot() * (float) (Math.PI / 180.0)) * 3;
                    if (!player.level().isClientSide()) {
                        ((ServerLevel)player.level()).sendParticles(ParticleTypes.SWEEP_ATTACK, player.getX() + d0, player.getY(0.5), player.getZ() + d1, 0, d0, 0.0, d1, 0.0);
                    }
                }

                if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemInit.TYRFINGER_SWORD)) {
                    Random rand = new Random();
                    double x = rand.nextDouble(0, 1.0);
                    if (x <= 0.7) {
                        player.getMainHandItem().set(DataComponents.ATTRIBUTE_MODIFIERS,
                                ItemAttributeModifiers.builder()
                                        .add(
                                                Attributes.ATTACK_DAMAGE,
                                                new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 5.0f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .add(
                                                Attributes.ATTACK_SPEED,
                                                new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Tool modifier",  10, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .build());
                    } else {
                        player.getMainHandItem().set(DataComponents.ATTRIBUTE_MODIFIERS,
                                ItemAttributeModifiers.builder()
                                        .add(
                                                Attributes.ATTACK_DAMAGE,
                                                new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 50.0f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .add(
                                                Attributes.ATTACK_SPEED,
                                                new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Tool modifier",  -10f, AttributeModifier.Operation.ADD_VALUE),
                                                EquipmentSlotGroup.MAINHAND
                                        )
                                        .build());
                    }
                }

            }

        }
    }
}
