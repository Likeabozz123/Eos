package xyz.gamars.eos.common.objects.items.wukongsstaff;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.DataComponentsInit;

import java.util.HashSet;
import java.util.function.Consumer;

public class WukongsStaffItem extends Item implements GeoItem, ICurioItem {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    public static final int MAX_SIZE = 39;

    public WukongsStaffItem(Properties properties) {
        super(properties);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
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


        }


        return super.use(level, player, usedHand);
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



}
