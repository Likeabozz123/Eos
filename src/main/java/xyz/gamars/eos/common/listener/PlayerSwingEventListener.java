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

        ItemInit.COOL_ASS_STICK.get().onPlayerSwing(event);
        ItemInit.PLUNGER.get().onPlayerSwing(event);
        ItemInit.TYRFINGER_SWORD.get().onPlayerSwing(event);

    }
}
