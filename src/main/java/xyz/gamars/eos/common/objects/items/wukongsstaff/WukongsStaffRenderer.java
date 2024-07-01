package xyz.gamars.eos.common.objects.items.wukongsstaff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import xyz.gamars.eos.Eos;

public class WukongsStaffRenderer extends GeoItemRenderer<WukongsStaffItem> {

    public WukongsStaffRenderer() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(Eos.MOD_ID, "wukongs_staff")));
    }
}
