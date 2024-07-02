package xyz.gamars.eos.common.objects.items.wukongsstaff;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import xyz.gamars.eos.Eos;

public class WukongsStaffRenderer extends GeoItemRenderer<WukongsStaffItem> {

    public WukongsStaffRenderer() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(Eos.MOD_ID, "wukongs_staff")));
    }
}
