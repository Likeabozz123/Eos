package xyz.gamars.eos.common.objects.items.wukongsstaff;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.client.KeyMappingInit;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.AttributeUUIDs;
import xyz.gamars.eos.common.objects.DataComponentsInit;
import xyz.gamars.eos.network.payloads.PullOutWukongStaffPayload;
import xyz.gamars.eos.utils.InventoryUtils;

import java.util.UUID;
import java.util.function.Consumer;

public class WukongsStaffItem extends Item implements GeoItem, ICurioItem {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    public static final int MAX_SIZE = 39;

    public WukongsStaffItem(Properties properties) {
        super(properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_UUID,
                                "Weapon modifier",
                                10.0,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Weapon modifier",
                                -2.4f,
                                AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(AttributeUUIDs.ENTITY_INTERACTION_RANGE_UUID,
                                "Weapon modifier",
                                0,
                                AttributeModifier.Operation.ADD_VALUE
                                ),
                                EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.BLOCK_INTERACTION_RANGE  ,
                        new AttributeModifier(AttributeUUIDs.BLOCK_INTERACTION_RANGE_UUID,
                                "Weapon modifier",
                                0,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        if (!level.isClientSide()) {

            ItemStack item = player.getMainHandItem();
            if (!player.isCrouching()) {
                item.update(DataComponentsInit.SIZE.value(), new SizeComponent(1, MAX_SIZE), s -> {
                    
                    int size = s.size();
                    size++;
                    if (size > s.maxSize()) {
                        size = 1;
                    }

                    return new SizeComponent(size, MAX_SIZE);
                });

            } else {
                item.update(DataComponentsInit.SIZE.value(), new SizeComponent(1, MAX_SIZE), s -> {

                    int size = s.size();
                    size--;
                    if (size <= 0) {
                        size = s.maxSize();
                    }

                    return new SizeComponent(size, MAX_SIZE);
                });
            }

            int size = item.get(DataComponentsInit.SIZE.value()).size();
            if (size >= 5) {
                modifyAttributes(item,
                        10.0 + (10 * (size / 30.0)),
                        -2.4 - (size / 30.0),
                        (size / 10.0),
                        (size / 10.0));
            } else {
                resetAttributes(item);
            }

        }

        return super.use(level, player, usedHand);
    }

    private void modifyAttributes(ItemStack item, double attackDamge, double attackSpeed, double entityReach, double blockReach) {
        InventoryUtils.modifyItemAttribute(item, Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                        "Weapon Modifier",
                        attackDamge,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                        "Weapon Modifier",
                        attackSpeed,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(AttributeUUIDs.ENTITY_INTERACTION_RANGE_UUID,
                        "Weapon Modifier",
                        entityReach,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(AttributeUUIDs.BLOCK_INTERACTION_RANGE_UUID,
                        "Weapon Modifier",
                        blockReach,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
    }

    private void resetAttributes(ItemStack item) {
        InventoryUtils.modifyItemAttribute(item, Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                        "Weapon Modifier",
                        10.0,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                        "Weapon Modifier",
                        -2.4,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(AttributeUUIDs.ENTITY_INTERACTION_RANGE_UUID,
                        "Weapon Modifier",
                        0,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
        InventoryUtils.modifyItemAttribute(item, Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(AttributeUUIDs.BLOCK_INTERACTION_RANGE_UUID,
                        "Weapon Modifier",
                        0,
                        AttributeModifier.Operation.ADD_VALUE
                ), EquipmentSlotGroup.MAINHAND
        );
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private WukongsStaffRenderer renderer;

            @Override
            public @Nullable BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new WukongsStaffRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity().level().isClientSide()) {
            while(KeyMappingInit.WHIP_OUT_STAFF.get().consumeClick()) {
                Player player = (Player) slotContext.entity();
                if (!InventoryUtils.isInventoryFull(player.getInventory().items)) {
                    PacketDistributor.sendToServer(new PullOutWukongStaffPayload(stack, slotContext.identifier(), slotContext.index()));
                }
            }
        }



    }
}
